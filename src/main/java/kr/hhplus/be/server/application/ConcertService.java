package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.Concert;
import kr.hhplus.be.server.domain.ConcertRepository;
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
}
