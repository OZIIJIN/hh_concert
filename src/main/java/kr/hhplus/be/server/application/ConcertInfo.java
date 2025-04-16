package kr.hhplus.be.server.application;

import java.time.LocalDateTime;
import kr.hhplus.be.server.domain.concert.Concert;
import kr.hhplus.be.server.domain.concertHall.ConcertHall;
import kr.hhplus.be.server.domain.concertHall.Seat;
import kr.hhplus.be.server.domain.concertSchedule.ConcertSchedule;

public class ConcertInfo {

  public record GetAvailableConcerts(
      Long concertId,
      String concertTitle,
      String concertArtist,
      String concertHallName,
      String concertHallLocation,
      Long concertScheduleId,
      LocalDateTime concertStartTime,
      LocalDateTime concertEndTime,
      int availableSeatsCount
  ) {

    public static GetAvailableConcerts from(Concert concert, ConcertHall concertHall,
        ConcertSchedule concertSchedule, int availableSeatsCount) {
      return new GetAvailableConcerts(
          concert.getId(),concert.getTitle(), concert.getArtist(),
          concertHall.getName(), concertHall.getLocation(),
          concertSchedule.getId(), concertSchedule.getStartTime(), concertSchedule.getEndTime(),
          availableSeatsCount
      );
    }
  }

  public record GetAvailableSeat(
      int seatNum
  ) {
    public static GetAvailableSeat from(Seat seat) {
      return new GetAvailableSeat(seat.getNumber());
    }
  }

}
