package kr.hhplus.be.server.presentation;

import java.util.List;
import java.util.UUID;
import kr.hhplus.be.server.domain.reservation.ReservationCommand.Reserve;

public class ReservationRequest {

  public record V1_Reservation(
      UUID userId,
      Long concertScheduleId,
      List<Long> seats
  ) {
    public Reserve toCommand() {
      return new Reserve(userId, concertScheduleId, seats);
    }
  }

}
