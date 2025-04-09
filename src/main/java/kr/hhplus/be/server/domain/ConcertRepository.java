package kr.hhplus.be.server.domain;

import java.util.List;

public interface ConcertRepository {

    List<Concert> findAvailableConcerts();
}
