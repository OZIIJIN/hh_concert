package kr.hhplus.be.server.infra;

import kr.hhplus.be.server.domain.concert.Concert;
import kr.hhplus.be.server.domain.concert.ConcertRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConcertRepositoryImpl implements ConcertRepository {
    @Override
    public List<Concert> findAvailableConcerts() {
        return List.of();
    }
}
