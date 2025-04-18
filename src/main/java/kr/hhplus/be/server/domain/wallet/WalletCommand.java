package kr.hhplus.be.server.domain.wallet;

import java.util.UUID;
import kr.hhplus.be.server.domain.user.UserId;

public class WalletCommand {

  public record Charge(
      UserId userId,
      int amount
  ) {

  }

  public record UserIdCommand(
      UserId userId
  ) {

    public static UserIdCommand from(UUID uuid) {
      return new UserIdCommand(new UserId(uuid));
    }
  }

}
