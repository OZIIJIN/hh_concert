package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.concert.Concert;
import kr.hhplus.be.server.domain.concert.ConcertId;
import kr.hhplus.be.server.domain.concert.ConcertRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertService {
    private final ConcertRepository concertRepository;

    public ConcertService(ConcertRepository concertRepository) {
        this.concertRepository = concertRepository;
    }

    public List<Concert> getAvailableConcertList() {
        return concertRepository.findAvailableConcerts();
    }

    public Concert findById(ConcertId concertId) {
        return concertRepository.findById(concertId.getValue());
    }
}
