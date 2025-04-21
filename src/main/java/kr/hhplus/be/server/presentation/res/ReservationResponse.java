package kr.hhplus.be.server.presentation.res;

import java.util.List;
import kr.hhplus.be.server.application.ReservationInfo;
import kr.hhplus.be.server.domain.concertHall.Seat;
import kr.hhplus.be.server.domain.reservation.ReservationId;

public class ReservationResponse {

  public record V1_Reservation(
      ReservationId reservationId,
      List<Seat> seats,
      int totalPrice) {
    public static V1_Reservation from(ReservationInfo.ReservationDetail info) {
      return new V1_Reservation(info.reservationId(), info.seats(), info.totalPrice());
    }
  }

}
