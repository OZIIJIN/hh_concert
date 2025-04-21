package kr.hhplus.be.server.presentation;

import java.util.UUID;
import kr.hhplus.be.server.application.WalletFacadeService;
import kr.hhplus.be.server.application.WalletInfo;
import kr.hhplus.be.server.domain.wallet.WalletCommand.UserIdCommand;
import kr.hhplus.be.server.presentation.req.WalletRequest.V1_Charge;
import kr.hhplus.be.server.presentation.res.WalletResponse;
import kr.hhplus.be.server.presentation.res.WalletResponse.V1_GetBalance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

  private final WalletFacadeService walletFacadeService;

  public WalletController(WalletFacadeService walletFacadeService) {
    this.walletFacadeService = walletFacadeService;
  }

  @PostMapping("/api/v1/wallets/charge")
  public ResponseEntity<Void> charge(@RequestBody V1_Charge req) {
    walletFacadeService.charge(req.toCommand());

    return ResponseEntity.ok().build();
  }

  @GetMapping("/api/v1/wallets/me")
  public ResponseEntity<V1_GetBalance> getBalance(@RequestParam UUID userId) {
    WalletInfo.Balance info = walletFacadeService.getBalance(UserIdCommand.from(userId));

    return ResponseEntity.ok().body(WalletResponse.V1_GetBalance.from(info));
  }
}
