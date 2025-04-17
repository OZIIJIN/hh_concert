package kr.hhplus.be.server.domain.user;

import java.util.UUID;

public class UserCommand {

  public record Id (
      UUID userId
  ) { }

}
