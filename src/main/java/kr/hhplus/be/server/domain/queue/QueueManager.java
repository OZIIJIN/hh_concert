package kr.hhplus.be.server.domain.queue;

import java.util.Optional;
import java.util.UUID;
import kr.hhplus.be.server.domain.user.UserId;

public interface QueueManager {
  QueueToken issue(UserId userId);
  QueueToken getValidToken(UserId userId);
  void validateToken(UUID tokenId);
  int getCurrentPosition();
  void expireToken(UUID tokenId);
  void enter(UUID tokenId);
  void leave(UUID tokenId);
}
