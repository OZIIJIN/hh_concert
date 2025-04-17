package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.concertHall.SeatId;
import kr.hhplus.be.server.domain.concertSchedule.ConcertScheduleId;
import kr.hhplus.be.server.domain.reservation.ReservationCommand.Reserve;
import kr.hhplus.be.server.domain.reservation.ReservationId;
import kr.hhplus.be.server.domain.reservation.ReservationRepository;
import kr.hhplus.be.server.domain.reservation.Reservation;
import kr.hhplus.be.server.domain.user.UserId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {

  private final ReservationRepository reservationRepository;

  public ReservationService(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  public int findReservedSeatsCountById(Long concertScheduleId) {
    return reservationRepository.countReservedSeats(concertScheduleId);
  }

  @Transactional
  public ReservationId createTemporary(Reserve cmd) {
    if (reservationRepository.existsAny(cmd.concertScheduleId(), cmd.seats())) {
      throw new IllegalArgumentException("이미 선택된 좌석이 존재합니다.");
    }

    Reservation reservation = Reservation.create(
        new ConcertScheduleId(cmd.concertScheduleId()), new UserId(cmd.userId()));

    reservation.reserveSeats(
        cmd.seats().stream().map(SeatId::new).toList()
    );

    Reservation savedReservation = reservationRepository.saveReservation(reservation);

    return new ReservationId(savedReservation.getId());
  }
}
