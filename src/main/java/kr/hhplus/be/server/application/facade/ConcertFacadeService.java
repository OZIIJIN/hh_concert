package kr.hhplus.be.server.application.facade;

import kr.hhplus.be.server.application.ConcertHallService;
import kr.hhplus.be.server.application.info.ConcertInfo.GetAvailableConcerts;
import kr.hhplus.be.server.application.info.ConcertInfo.GetAvailableSeat;
import kr.hhplus.be.server.application.ConcertScheduleService;
import kr.hhplus.be.server.application.ConcertService;
import kr.hhplus.be.server.application.ReservationService;
import kr.hhplus.be.server.domain.concert.Concert;
import kr.hhplus.be.server.domain.concertHall.ConcertHall;
import kr.hhplus.be.server.domain.concertHall.Seat;
import kr.hhplus.be.server.domain.concertSchedule.ConcertSchedule;
import kr.hhplus.be.server.domain.concertSchedule.ConcertScheduleCommand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertFacadeService {

  private final ConcertService concertService;
  private final ConcertScheduleService concertScheduleService;
  private final ConcertHallService concertHallService;
  private final ReservationService reservationService;

  public ConcertFacadeService(ConcertService concertService,
      ConcertScheduleService concertScheduleService, ConcertHallService concertHallService,
      ReservationService reservationService) {
    this.concertService = concertService;
    this.concertScheduleService = concertScheduleService;
    this.concertHallService = concertHallService;
    this.reservationService = reservationService;
  }

  public List<GetAvailableConcerts> getAvailableConcertList() {
    List<ConcertSchedule> schedules = concertScheduleService.findUpComingConcert();

    return schedules.stream()
        .map(schedule -> {
          Concert concert = concertService.findById(schedule.getConcertId());
          ConcertHall concertHall = concertHallService.findById(schedule.getConcertHallId());

          //TODO : Id - VO로 관리하는 것으로 통일
          int totalSeats = concertHallService.findTotalSeatsCountById(concertHall.getId());
          int reservedSeats = reservationService.findReservedSeatsCountById(schedule.getId());
          int availableSeats = totalSeats - reservedSeats;

          return GetAvailableConcerts.from(concert, concertHall, schedule, availableSeats);
        }).toList();
  }

  public List<GetAvailableSeat> getAvailableSeats(ConcertScheduleCommand.Id cmd) {
    ConcertSchedule concertSchedule = concertScheduleService.findById(cmd);
    List<Seat> availableSeats = concertHallService.findAvailableSeats(concertSchedule.getConcertHallId());

    return availableSeats.stream().map(GetAvailableSeat::from).toList();
  }
}
