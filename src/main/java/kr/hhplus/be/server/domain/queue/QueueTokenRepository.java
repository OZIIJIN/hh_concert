package kr.hhplus.be.server.domain.queue;

import kr.hhplus.be.server.domain.user.UserId;

public interface QueueTokenRepository {

  boolean existsValidToken(UserId userId);

  int countAllValid();

  QueueToken save(QueueToken token);
}
