package kr.hhplus.be.server.domain.user;

import java.util.UUID;

public class UserCommand {

  public record Id (
      UUID userId
  ) {
    public static Id from(UUID userId) {
      return new Id(userId);
    }
  }

}
