package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.reservation.ReservationId;

public class ReservationInfo {

  public record Id(
      ReservationId reservationId
  ) {

  }

}
