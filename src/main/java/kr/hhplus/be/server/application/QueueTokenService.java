package kr.hhplus.be.server.application;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import kr.hhplus.be.server.domain.queue.QueueToken;
import kr.hhplus.be.server.domain.queue.QueueTokenRepository;
import kr.hhplus.be.server.domain.user.UserId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QueueTokenService {
  private final QueueTokenRepository queueTokenRepository;
  private static final Duration TTL = Duration.ofMinutes(10);

  public QueueTokenService(QueueTokenRepository queueTokenRepository) {
    this.queueTokenRepository = queueTokenRepository;
  }

  @Transactional
  public UUID issueToken(UserId userId) {
    if (queueTokenRepository.existsValidToken(userId)) {
      throw new IllegalArgumentException("이미 대기열에 진입하셨습니다.");
    }
    int position = queueTokenRepository.countAllValid() + 1;
    QueueToken token = QueueToken.issue(userId, position, TTL);
    return queueTokenRepository.save(token).getId();
  }

  @Transactional(readOnly = true)
  public void validate(UUID tokenId) {
    QueueToken token = queueTokenRepository.findById(tokenId);
    if (token.isExpired()) throw new IllegalArgumentException("만료된 토큰 입니다.");

    int current = getCurrentPosition();
    if (!token.isAccessible(current)) throw new IllegalArgumentException("접근 불가");
  }

  @Transactional(readOnly = true)
  public QueueTokenInfo.QueueTokenDetail getMyPosition(UserId userId) {
    int currentPosition = getCurrentPosition();
    int userPosition = getValidToken(userId).getPosition();
    return new QueueTokenInfo.QueueTokenDetail(userPosition, currentPosition);
  }

  public void enterNext() {
    int currentPosition = getCurrentPosition();

    QueueToken next = queueTokenRepository.findFirstWaitingAfter(currentPosition);

    if(!next.isExpired()) {
      next.toEntered();
    }
  }

  @Transactional(readOnly = true)
  public int getCurrentPosition() {
    return queueTokenRepository.getCurrentServedPosition() + 1;
  }

  @Transactional(readOnly = true)
  public QueueToken getValidToken(UserId userId) {
    return queueTokenRepository.findValidByUserId(userId);
  }

  public void exitAfterPayment(UserId userId) {
    QueueToken token = getValidToken(userId);
    validate(token.getId());
    token.toExited();
  }

  public List<QueueToken> findExpiredTokens(LocalDateTime now) {
    return queueTokenRepository.findExpiredTokens(now);
  }
}
