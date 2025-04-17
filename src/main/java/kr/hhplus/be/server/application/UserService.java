package kr.hhplus.be.server.application;

import java.util.UUID;
import kr.hhplus.be.server.domain.user.User;
import kr.hhplus.be.server.domain.user.UserCommand;
import kr.hhplus.be.server.domain.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User findByUserId(UserCommand.Id cmd) {
    return userRepository.findByUserId(cmd.userId());
  }

}
