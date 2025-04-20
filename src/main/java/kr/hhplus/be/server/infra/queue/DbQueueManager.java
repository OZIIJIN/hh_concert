package kr.hhplus.be.server.infra.queue;

import java.time.Duration;
import java.util.UUID;
import kr.hhplus.be.server.domain.queue.QueueManager;
import kr.hhplus.be.server.domain.queue.QueueToken;
import kr.hhplus.be.server.domain.queue.QueueTokenRepository;
import kr.hhplus.be.server.domain.user.UserId;
import org.springframework.stereotype.Component;

@Component
public class DbQueueManager implements QueueManager {

  private final QueueTokenRepository queueTokenRepository;
  private static final Duration TTL = Duration.ofMinutes(10);

  public DbQueueManager(QueueTokenRepository queueTokenRepository) {
    this.queueTokenRepository = queueTokenRepository;
  }

  @Override
  public QueueToken issue(UserId userId) {
    if (queueTokenRepository.existsValidToken(userId)) {
      throw new IllegalArgumentException("이미 대기열에 진입하셨습니다.");
    }
    int position = queueTokenRepository.countAllValid() + 1;

    QueueToken token = QueueToken.issue(userId, position, TTL);
    return queueTokenRepository.save(token);
  }

  @Override
  public QueueToken getValidToken(UserId userId) {
    return queueTokenRepository.findValidByUserId(userId);  }

  @Override
  public void validateToken(UUID tokenId) {
    QueueToken token = queueTokenRepository.findById(tokenId);

    if (token.isExpired()) throw new IllegalArgumentException("만료된 토큰 입니다.");

    int current = getCurrentPosition();
    if (!token.isAccessible(current)) throw new IllegalArgumentException("접근 불가");
  }

  @Override
  public int getCurrentPosition() {
    return queueTokenRepository.getCurrentServedPosition() + 1;
  }

  @Override
  public void expireToken(UUID tokenId) {
    QueueToken token = queueTokenRepository.findById(tokenId);
    token.toExpired();
  }

  @Override
  public void exit(UUID tokenId) {
    QueueToken token = queueTokenRepository.findById(tokenId);
    token.toExited();
  }

  @Override
  public void enterNext() {
    int currentPosition = getCurrentPosition();

    QueueToken next = queueTokenRepository.findFirstWaitingAfter(currentPosition);

    if(next.isExpired()) {
      next.toEntered();
    }
  }
}
