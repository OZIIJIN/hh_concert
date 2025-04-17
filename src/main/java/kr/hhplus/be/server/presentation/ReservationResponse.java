package kr.hhplus.be.server.presentation;

import kr.hhplus.be.server.application.ReservationInfo;
import kr.hhplus.be.server.domain.reservation.ReservationId;

public class ReservationResponse {

  public record V1_Reservation(ReservationId reservationId) {
    public static V1_Reservation from(ReservationInfo.Id info) {
      return new V1_Reservation(info.reservationId());
    }
  }

}
