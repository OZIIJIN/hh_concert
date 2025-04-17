package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.wallet.Wallet;

public class WalletInfo {

  public record Balance(
      int Balance
  ) {
    public static Balance from(int balance) {
      return new Balance(balance);
    }
  }

}
