package kr.hhplus.be.server.application.facade;

import kr.hhplus.be.server.application.info.WalletInfo;
import kr.hhplus.be.server.application.info.WalletInfo.Balance;
import kr.hhplus.be.server.application.WalletService;
import kr.hhplus.be.server.domain.wallet.WalletCommand.Charge;
import kr.hhplus.be.server.domain.wallet.WalletCommand.UserIdCommand;
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

  public Balance getBalance(UserIdCommand cmd) {
    int balance = walletService.getBalance(cmd);

    return WalletInfo.Balance.from(balance);
  }
}
