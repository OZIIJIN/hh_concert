package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.user.User;
import kr.hhplus.be.server.domain.user.UserCommand;
import kr.hhplus.be.server.domain.wallet.WalletCommand.Charge;
import org.springframework.stereotype.Service;

@Service
public class WalletFacadeService {

  private final WalletService walletService;

  private final UserService userService;

  public WalletFacadeService(WalletService walletService, UserService userService) {
    this.walletService = walletService;
    this.userService = userService;
  }

  public void charge(Charge cmd) {
    walletService.charge(cmd);
  }
}
