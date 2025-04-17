package kr.hhplus.be.server.domain.wallet;

import java.util.UUID;

public interface WalletRepository {

  Wallet findWalletByUserId(UUID uuid);
}
