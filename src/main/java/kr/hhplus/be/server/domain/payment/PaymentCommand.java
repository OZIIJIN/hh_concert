package kr.hhplus.be.server.domain.payment;

import kr.hhplus.be.server.domain.reservation.ReservationId;

public class PaymentCommand {

  public record Pay(
      ReservationId reservationId,
      int totalPrice
  ) {

  }

}
