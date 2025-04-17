package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.concertHall.SeatId;
import kr.hhplus.be.server.domain.concertSchedule.ConcertScheduleId;
import kr.hhplus.be.server.domain.reservation.Reservation;
import kr.hhplus.be.server.domain.reservation.ReservationCommand.CreateReservedSeats;
import kr.hhplus.be.server.domain.reservation.ReservationCommand.Reserve;
import kr.hhplus.be.server.domain.reservation.ReservationId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationFacadeService {

  private final ReservationService reservationService;

  public ReservationFacadeService(ReservationService reservationService) {
    this.reservationService = reservationService;
  }

  public ReservationInfo.Id reservationSeats(Reserve cmd) {
    ReservationId reservationId = reservationService.createTemporary(cmd);

    return new ReservationInfo.Id(reservationId);
  }
}
