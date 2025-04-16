package kr.hhplus.be.server.domain.concertHall;

public interface ConcertHallRepository {

  ConcertHall findById(Long value);

  int countTotalSeats(Long concertHallId);
}
