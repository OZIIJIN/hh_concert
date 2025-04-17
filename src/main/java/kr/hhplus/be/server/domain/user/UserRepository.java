package kr.hhplus.be.server.domain.user;

import java.util.UUID;

public interface UserRepository {

  User findByUserId(UUID userId);
}
