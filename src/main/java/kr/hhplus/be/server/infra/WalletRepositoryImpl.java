package kr.hhplus.be.server.infra;

import java.util.UUID;
import kr.hhplus.be.server.domain.wallet.Wallet;
import kr.hhplus.be.server.domain.wallet.WalletRepository;
import org.springframework.stereotype.Repository;

@Repository
public class WalletRepositoryImpl implements WalletRepository {

  @Override
  public Wallet findWalletByUserId(UUID uuid) {
    return null;
  }
}
