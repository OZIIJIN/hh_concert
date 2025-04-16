package kr.hhplus.be.server.domain.concertSchedule;

public class ConcertScheduleCommand {

  public record Id(
      Long concertScheduleId
  ) {
    public static Id fromId(Long concertScheduleId) {
      return new Id(concertScheduleId);
    }
  }

}
