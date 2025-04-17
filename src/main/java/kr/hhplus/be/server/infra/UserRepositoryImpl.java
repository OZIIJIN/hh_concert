package kr.hhplus.be.server.infra;

import java.util.UUID;
import kr.hhplus.be.server.domain.user.User;
import kr.hhplus.be.server.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

  @Override
  public User findByUserId(UUID userId) {
    return null;
  }
}
