package kr.hhplus.be.server.domain.payment;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.hhplus.be.server.domain.reservation.ReservationId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "payments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  private ReservationId reservationId;

  @Column
  private int amount;

  private Payment(ReservationId reservationId, int amount) {
    this.reservationId = reservationId;
    this.amount = amount;
  }

  public static Payment create(ReservationId reservationId, int amount) {
    return new Payment(reservationId, amount);
  }

}
