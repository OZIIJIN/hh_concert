package kr.hhplus.be.server.presentation;

import kr.hhplus.be.server.application.WalletFacadeService;
import kr.hhplus.be.server.domain.wallet.Wallet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {

  private final WalletFacadeService walletFacadeService;

  public WalletController(WalletFacadeService walletFacadeService) {
    this.walletFacadeService = walletFacadeService;
  }

  @PostMapping("/api/v1/wallets/charge")
  public ResponseEntity<Void> charge(@RequestBody WalletRequest.V1_Charge req) {
    walletFacadeService.charge(req.toCommand());

    return ResponseEntity.ok().build();
  }

}
