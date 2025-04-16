package kr.hhplus.be.server.domain.concert;

import java.util.List;

public interface ConcertRepository {

    List<Concert> findAvailableConcerts();

    Concert findById(Long value);
}
