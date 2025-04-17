package kr.hhplus.be.server.infra;

import java.util.List;
import kr.hhplus.be.server.domain.reservation.Reservation;
import kr.hhplus.be.server.domain.reservation.ReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

  @Override
  public int countReservedSeats(Long concertScheduleId) {
    return 0;
  }

  @Override
  public boolean existsAny(Long aLong, List<Long> seats) {
    return false;
  }

  @Override
  public Reservation saveReservation(Reservation reservation) {
    return null;
  }
}
