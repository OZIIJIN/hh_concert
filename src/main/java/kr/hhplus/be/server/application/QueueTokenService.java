package kr.hhplus.be.server.application;

import java.util.UUID;
import kr.hhplus.be.server.domain.queue.QueueManager;
import kr.hhplus.be.server.domain.queue.QueueToken;
import kr.hhplus.be.server.domain.user.UserId;
import org.springframework.stereotype.Service;

@Service
public class QueueTokenService {

  private final QueueManager queueManager;

  public QueueTokenService(QueueManager queueManager) {
    this.queueManager = queueManager;
  }

  public UUID issueToken(UserId userId) {
    return queueManager.issue(userId).getId();
  }

  public void validate(UUID tokenId) {
    queueManager.validateToken(tokenId);
  }

  public int getMyPosition(UserId userId) {
    return queueManager.getValidToken(userId).getPosition();
  }

  public void enter(UUID tokenId) {
    queueManager.enter(tokenId);
  }

  public void leave(UUID tokenId) {
    queueManager.exit(tokenId);
  }

  public int getCurrentPosition() {
    return queueManager.getCurrentPosition();
  }

  public QueueToken getValidToken(UserId userId) {
    return queueManager.getValidToken(userId);
  }
}
