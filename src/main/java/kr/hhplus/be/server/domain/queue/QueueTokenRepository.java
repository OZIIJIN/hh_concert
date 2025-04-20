package kr.hhplus.be.server.domain.queue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import kr.hhplus.be.server.domain.user.UserId;

public interface QueueTokenRepository {

  boolean existsValidToken(UserId userId);

  int countAllValid();

  QueueToken save(QueueToken token);

  QueueToken findValidByUserId(UserId userId);

  QueueToken findById(UUID tokenId);

  int getCurrentServedPosition();

  QueueToken findFirstWaitingAfter(int currentPosition);

  List<QueueToken> findExpiredTokens(LocalDateTime now);
}
