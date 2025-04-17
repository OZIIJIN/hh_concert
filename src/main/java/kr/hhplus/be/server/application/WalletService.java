package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.wallet.Wallet;
import kr.hhplus.be.server.domain.wallet.WalletCommand.Charge;
import kr.hhplus.be.server.domain.wallet.WalletCommand.UserId;
import kr.hhplus.be.server.domain.wallet.WalletRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletService {

  private final WalletRepository walletRepository;

  public WalletService(WalletRepository walletRepository) {
    this.walletRepository = walletRepository;
  }

  @Transactional
  public void charge(Charge cmd) {
    Wallet wallet = walletRepository.findWalletByUserId(cmd.userId());

    wallet.charge(cmd.amount());
  }

  @Transactional(readOnly = true)
  public int getBalance(UserId cmd) {
    Wallet wallet = walletRepository.findWalletByUserId(cmd.userId());
    return wallet.getBalance();
  }
}
