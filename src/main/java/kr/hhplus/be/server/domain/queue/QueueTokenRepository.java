package kr.hhplus.be.server.domain.queue;

import java.util.UUID;
import kr.hhplus.be.server.domain.user.UserId;

public interface QueueTokenRepository {

  boolean existsValidToken(UserId userId);

  int countAllValid();

  QueueToken save(QueueToken token);

  QueueToken findValidByUserId(UserId userId);

  QueueToken findById(UUID tokenId);
}
