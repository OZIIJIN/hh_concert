package kr.hhplus.be.server.application;

import java.util.List;
import kr.hhplus.be.server.domain.concertSchedule.ConcertSchedule;
import kr.hhplus.be.server.domain.concertSchedule.ConcertScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ConcertScheduleService {

  private final ConcertScheduleRepository concertScheduleRepository;

  public ConcertScheduleService(ConcertScheduleRepository concertScheduleRepository) {
    this.concertScheduleRepository = concertScheduleRepository;
  }

  public List<ConcertSchedule> findUpComingConcert() {
    return concertScheduleRepository.findUpcomingConcert();
  }
}
