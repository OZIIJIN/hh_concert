package kr.hhplus.be.server.domain.reservation;

import java.util.List;
import java.util.UUID;
import kr.hhplus.be.server.domain.concertHall.SeatId;
import kr.hhplus.be.server.domain.concertSchedule.ConcertScheduleId;

public class ReservationCommand {

  public record Reserve(
      UUID userId,
      Long concertScheduleId,
      List<Long> seats
  ) {
  }

  public record CreateReservedSeats(
      SeatId seatId,
      ConcertScheduleId concertScheduleId,
      ReservationId reservationId
  ) {
  }

}
