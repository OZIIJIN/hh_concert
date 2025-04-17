package kr.hhplus.be.server.domain.wallet;

import java.util.UUID;

public class WalletCommand {

  public record Charge(
      UUID userId,
      int amount
  ) {
  }

}
