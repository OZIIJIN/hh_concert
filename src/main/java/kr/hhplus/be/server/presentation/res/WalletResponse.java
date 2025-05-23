package kr.hhplus.be.server.presentation.res;

import kr.hhplus.be.server.application.info.WalletInfo;

public class WalletResponse {

  public record V1_GetBalance(
      int balance
  ) {
    public static V1_GetBalance from(WalletInfo.Balance info) {
      return new V1_GetBalance(info.Balance());
    }
  }

}
