package kr.hhplus.be.server.domain.wallet;

import java.util.UUID;
import kr.hhplus.be.server.domain.user.UserId;

public interface WalletRepository {

  Wallet findWalletByUserId(UserId uuid);
}
