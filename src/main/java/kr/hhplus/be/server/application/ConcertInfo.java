package kr.hhplus.be.server.application;

import java.time.LocalDateTime;
import java.util.List;
import kr.hhplus.be.server.domain.concert.Concert;
import kr.hhplus.be.server.domain.concertHall.ConcertHall;
import kr.hhplus.be.server.domain.concertSchedule.ConcertSchedule;

public class ConcertInfo {

  public record V1_GetAvailable(
      Long concertId,
      String concertTitle,
      String concertArtist,
      String concertHallName,
      String concertHallLocation,
      LocalDateTime concertStartTime,
      LocalDateTime concertEndTime,
      int availableSeatsCount
  ) {

    public static V1_GetAvailable from(Concert concert, ConcertHall concertHall,
        ConcertSchedule concertSchedule, int availableSeatsCount) {
      return new V1_GetAvailable(
          concert.getId(),concert.getTitle(), concert.getArtist(),
          concertHall.getName(), concertHall.getLocation(),
          concertSchedule.getStartTime(), concertSchedule.getEndTime(),
          availableSeatsCount
      );
    }
  }

}
