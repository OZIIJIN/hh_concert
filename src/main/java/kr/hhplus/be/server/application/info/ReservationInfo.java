package kr.hhplus.be.server.application.info;

import java.util.List;
import kr.hhplus.be.server.domain.concertHall.Seat;
import kr.hhplus.be.server.domain.reservation.ReservationId;

public class ReservationInfo {

  public record Id(
      ReservationId reservationId
  ) {

  }

  public record ReservationDetail(
      ReservationId reservationId,
      List<Seat> seats,
      int totalPrice
  ) {

    public static ReservationDetail from(ReservationId reservationId, List<Seat> seats,
        int totalPrice) {
      return new ReservationDetail(reservationId, seats, totalPrice);
    }
  }

}
