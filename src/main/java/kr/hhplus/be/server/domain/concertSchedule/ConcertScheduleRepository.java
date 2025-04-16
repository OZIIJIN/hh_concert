package kr.hhplus.be.server.domain.concertSchedule;

import java.util.List;

public interface ConcertScheduleRepository {

  List<ConcertSchedule> findUpcomingConcert();
}
