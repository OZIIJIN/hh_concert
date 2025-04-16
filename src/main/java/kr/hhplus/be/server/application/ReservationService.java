package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.reservation.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

  private final ReservationRepository reservationRepository;

  public ReservationService(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  public int findReservedSeatsCountById(Long concertScheduleId) {
    return reservationRepository.countReservedSeats(concertScheduleId);
  }
}
