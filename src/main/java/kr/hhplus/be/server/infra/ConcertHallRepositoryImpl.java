package kr.hhplus.be.server.infra;

import java.util.List;
import kr.hhplus.be.server.domain.concertHall.ConcertHall;
import kr.hhplus.be.server.domain.concertHall.ConcertHallRepository;
import kr.hhplus.be.server.domain.concertHall.Seat;
import org.springframework.stereotype.Repository;

@Repository
public class ConcertHallRepositoryImpl implements ConcertHallRepository {

  @Override
  public ConcertHall findById(Long value) {
    return null;
  }

  @Override
  public int countTotalSeats(Long concertHallId) {
    return 0;
  }

  @Override
  public List<Seat> findAvailableSeats(Long value) {
    return List.of();
  }

  @Override
  public Seat findSeatBySeatId(Long seatId) {
    return null;
  }
}
