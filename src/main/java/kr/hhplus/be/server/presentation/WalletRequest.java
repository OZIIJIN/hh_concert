package kr.hhplus.be.server.presentation;

import java.util.UUID;
import kr.hhplus.be.server.domain.user.UserId;
import kr.hhplus.be.server.domain.wallet.WalletCommand;

public class WalletRequest {

  public record V1_Charge(
      UUID userId,
      int amount
  ) {
    public WalletCommand.Charge toCommand() {
      return new WalletCommand.Charge(new UserId(userId), amount);
    }
  }

}
