package kr.hhplus.be.server.application;

import kr.hhplus.be.server.application.ConcertInfo.V1_GetAvailable;
import kr.hhplus.be.server.domain.concert.Concert;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertFacadeService {
    private final ConcertService concertService;

    public ConcertFacadeService(ConcertService concertService) {
        this.concertService = concertService;
    }

    public List<V1_GetAvailable> getAvailableConcertList() {
      return List.of();
    }
}
