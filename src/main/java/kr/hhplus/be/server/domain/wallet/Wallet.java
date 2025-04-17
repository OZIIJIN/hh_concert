package kr.hhplus.be.server.domain.wallet;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.hhplus.be.server.domain.user.UserId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "wallets")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Wallet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private int balance;

  @Embedded
  private UserId userId;

  private Wallet(UserId userId) {
    this.userId = userId;
    this.balance = 0;
  }

  public static Wallet create(UserId userId) {
    return new Wallet(userId);
  }

  public void charge(int amount) {
    validatePositiveAmount(amount);
    this.balance += amount;
  }

  public void use(int amount) {
    validatePositiveAmount(amount);
    validateEnoughBalance(amount);
    this.balance -= amount;
  }

  private void validateEnoughBalance(int amount) {
    if (this.balance < amount) {
      throw new IllegalArgumentException("잔액이 부족합니다.");
    }
  }

  private void validatePositiveAmount(int amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException("금액은 0보다 커야 합니다.");
    }
  }
}
