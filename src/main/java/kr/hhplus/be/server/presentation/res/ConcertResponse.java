package kr.hhplus.be.server.presentation.res;

import java.time.LocalDateTime;

import java.util.List;
import kr.hhplus.be.server.application.info.ConcertInfo;
import kr.hhplus.be.server.application.info.ConcertInfo.GetAvailableConcerts;

public class ConcertResponse {

  public record V1_GetAvailable(
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
    public static V1_GetAvailable from(GetAvailableConcerts concertInfo) {
      return new V1_GetAvailable(
          concertInfo.concertId(), concertInfo.concertTitle(), concertInfo.concertArtist(),
          concertInfo.concertHallName(), concertInfo.concertHallLocation(),
          concertInfo.concertScheduleId(), concertInfo.concertStartTime(), concertInfo.concertEndTime(),
          concertInfo.availableSeatsCount()
      );
    }
  }

  public record V1_GetAvailableList(
      List<V1_GetAvailable> concerts
  ) {
    public static V1_GetAvailableList from(List<GetAvailableConcerts> info) {
      return new V1_GetAvailableList(
          info.stream().map(V1_GetAvailable::from).toList()
      );
    }
  }

  public record V1_GetAvailableSeat(
      int seatNum
  ) {
    public static V1_GetAvailableSeat from(ConcertInfo.GetAvailableSeat info) {
      return new V1_GetAvailableSeat(info.seatNum());
    }
  }

  public record V1_GetAvailableSeats(
      List<V1_GetAvailableSeat> seatNums
  ) {
    public static V1_GetAvailableSeats from(List<ConcertInfo.GetAvailableSeat> info) {
      return new V1_GetAvailableSeats(
          info.stream().map(V1_GetAvailableSeat::from).toList()
      );
    }
  }
}
