package kr.hhplus.be.server.application;

import kr.hhplus.be.server.application.ConcertInfo.V1_GetAvailable;
import kr.hhplus.be.server.domain.concert.Concert;
import kr.hhplus.be.server.domain.concertHall.ConcertHall;
import kr.hhplus.be.server.domain.concertSchedule.ConcertSchedule;
import kr.hhplus.be.server.presentation.ConcertResponse.GetConcertDetail;
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

    public List<V1_GetAvailable> getAvailableConcertList() {
        List<ConcertSchedule> schedules = concertScheduleService.findUpComingConcert();

      return schedules.stream()
          .map(schedule -> {
              Concert concert = concertService.findById(schedule.getConcertId());
              ConcertHall concertHall = concertHallService.findById(schedule.getConcertHallId());

              //TODO : Id - VO로 관리하는 것으로 통일
              int totalSeats = concertHallService.findTotalSeatsCountById(concertHall.getId());
              int reservedSeats = reservationService.findReservedSeatsCountById(schedule.getId());
              int availableSeats = totalSeats - reservedSeats;

              return V1_GetAvailable.from(concert, concertHall, schedule, availableSeats);
          }).toList();
    }
}
