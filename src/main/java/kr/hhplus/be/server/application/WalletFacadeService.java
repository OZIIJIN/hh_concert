package kr.hhplus.be.server.application;

import kr.hhplus.be.server.application.WalletInfo.Balance;
import kr.hhplus.be.server.domain.wallet.Wallet;
import kr.hhplus.be.server.domain.wallet.WalletCommand.Charge;
import kr.hhplus.be.server.domain.wallet.WalletCommand.UserId;
import org.springframework.stereotype.Service;

@Service
public class WalletFacadeService {

  private final WalletService walletService;

  public WalletFacadeService(WalletService walletService) {
    this.walletService = walletService;
  }

  public void charge(Charge cmd) {
    walletService.charge(cmd);
  }

  public Balance getBalance(UserId cmd) {
    int balance = walletService.getBalance(cmd);

    return WalletInfo.Balance.from(balance);
  }
}
