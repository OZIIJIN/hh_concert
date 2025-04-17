package kr.hhplus.be.server.infra;

import java.util.List;
import kr.hhplus.be.server.domain.concertSchedule.ConcertSchedule;
import kr.hhplus.be.server.domain.concertSchedule.ConcertScheduleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConcertScheduleRepositoryImpl implements ConcertScheduleRepository {

  @Override
  public List<ConcertSchedule> findUpcomingConcert() {
    return List.of();
  }

  @Override
  public ConcertSchedule findById(Long concertScheduleId) {
    return null;
  }
}
