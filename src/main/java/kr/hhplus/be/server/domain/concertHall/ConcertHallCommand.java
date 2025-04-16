package kr.hhplus.be.server.domain.concertHall;

public class ConcertHallCommand {
  
  public record Id(
      Long concertHallId
  ) {
    public static Id from(Long concertHallId) {
      return new Id(concertHallId);
    }
  }

}
