package kr.hhplus.be.server.presentation;

import kr.hhplus.be.server.domain.payment.PaymentCommand;
import kr.hhplus.be.server.domain.payment.PaymentCommand.Pay;
import kr.hhplus.be.server.domain.reservation.ReservationId;

public class PaymentRequest {

  public record V1_PayReservation(
      Long reservationId,
      int totalPrice
  ) {
    public PaymentCommand.Pay toCommand() {
      return new Pay(new ReservationId(reservationId), totalPrice);
    }
  }

}
