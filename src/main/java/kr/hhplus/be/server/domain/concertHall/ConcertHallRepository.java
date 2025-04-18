package kr.hhplus.be.server.domain.concertHall;

import java.util.List;

public interface ConcertHallRepository {

  ConcertHall findById(Long value);

  int countTotalSeats(Long concertHallId);

  List<Seat> findAvailableSeats(Long value);

  Seat findSeatBySeatId(Long seatId);
}
