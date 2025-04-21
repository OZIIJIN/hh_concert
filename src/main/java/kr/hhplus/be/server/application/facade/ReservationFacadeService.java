package kr.hhplus.be.server.application.facade;

import java.util.List;
import kr.hhplus.be.server.application.ConcertHallService;
import kr.hhplus.be.server.application.info.ReservationInfo.ReservationDetail;
import kr.hhplus.be.server.application.ReservationService;
import kr.hhplus.be.server.domain.concertHall.Seat;
import kr.hhplus.be.server.domain.reservation.ReservationCommand.Reserve;
import kr.hhplus.be.server.domain.reservation.ReservationId;
import org.springframework.stereotype.Service;

@Service
public class ReservationFacadeService {

  private final ReservationService reservationService;
  private final ConcertHallService concertHallService;

  public ReservationFacadeService(ReservationService reservationService,
      ConcertHallService concertHallService) {
    this.reservationService = reservationService;
    this.concertHallService = concertHallService;
  }

  public ReservationDetail reservationSeats(Reserve cmd) {
    ReservationId reservationId = reservationService.createTemporary(cmd);

    List<Seat> seats = concertHallService.findSeatBySeatIds(cmd.seats());

    int totalPrice = seats.stream().mapToInt(Seat::getPrice).sum();

    return ReservationDetail.from(reservationId, seats, totalPrice);
  }
}
