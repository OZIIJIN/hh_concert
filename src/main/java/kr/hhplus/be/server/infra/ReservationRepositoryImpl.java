package kr.hhplus.be.server.infra;

import kr.hhplus.be.server.domain.reservation.ReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

  @Override
  public int countReservedSeats(Long concertScheduleId) {
    return 0;
  }
}
