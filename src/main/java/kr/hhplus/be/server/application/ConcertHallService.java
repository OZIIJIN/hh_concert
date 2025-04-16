package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.concertHall.ConcertHall;
import kr.hhplus.be.server.domain.concertHall.ConcertHallId;
import kr.hhplus.be.server.domain.concertHall.ConcertHallRepository;
import org.springframework.stereotype.Service;

@Service
public class ConcertHallService {

  private final ConcertHallRepository concertHallRepository;

  public ConcertHallService(ConcertHallRepository concertHallRepository) {
    this.concertHallRepository = concertHallRepository;
  }

  public ConcertHall findById(ConcertHallId concertHallId) {
    return concertHallRepository.findById(concertHallId.getValue());
  }

  public int findTotalSeatsCountById(Long concertHallId) {
    return concertHallRepository.countTotalSeats(concertHallId);
  }
}
