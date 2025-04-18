package kr.hhplus.be.server.application;

import java.util.List;
import kr.hhplus.be.server.application.ReservationInfo.ReservationDetail;
import kr.hhplus.be.server.domain.concertHall.Seat;
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
  private final ConcertHallService concertHallService;

  public ReservationFacadeService(ReservationService reservationService,
      ConcertHallService concertHallService) {
    this.reservationService = reservationService;
    this.concertHallService = concertHallService;
  }

  public ReservationInfo.ReservationDetail reservationSeats(Reserve cmd) {
    ReservationId reservationId = reservationService.createTemporary(cmd);

    List<Seat> seats = concertHallService.findSeatBySeatIds(cmd.seats());

    int totalPrice = seats.stream().mapToInt(Seat::getPrice).sum();

    return ReservationDetail.from(reservationId, seats, totalPrice);
  }
}
