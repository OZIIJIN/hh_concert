package kr.hhplus.be.server.infra;

import java.util.UUID;
import kr.hhplus.be.server.domain.queue.QueueToken;
import kr.hhplus.be.server.domain.queue.QueueTokenRepository;
import kr.hhplus.be.server.domain.user.UserId;
import org.springframework.stereotype.Repository;

@Repository
public class QueueTokenRepositoryImpl implements QueueTokenRepository {

  @Override
  public boolean existsValidToken(UserId userId) {
    return false;
  }

  @Override
  public int countAllValid() {
    return 0;
  }

  @Override
  public QueueToken save(QueueToken token) {
    return null;
  }

  @Override
  public QueueToken findValidByUserId(UserId userId) {
    return null;
  }

  @Override
  public QueueToken findById(UUID tokenId) {
    return null;
  }

  @Override
  public int getCurrentServedPosition() {
    return 0;
  }

  @Override
  public QueueToken findFirstWaitingAfter(int currentPosition) {
    return null;
  }
}
