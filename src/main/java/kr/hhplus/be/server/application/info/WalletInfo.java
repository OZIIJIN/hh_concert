package kr.hhplus.be.server.application.info;

public class WalletInfo {

  public record Balance(
      int Balance
  ) {
    public static Balance from(int balance) {
      return new Balance(balance);
    }
  }

}
