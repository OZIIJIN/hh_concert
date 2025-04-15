package kr.hhplus.be.server.presentation;

import kr.hhplus.be.server.application.ConcertFacadeService;
import kr.hhplus.be.server.application.ConcertInfo;
import kr.hhplus.be.server.domain.concert.Concert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/concerts")
public class ConcertController {
    private final ConcertFacadeService concertFacadeService;

    public ConcertController(ConcertFacadeService concertFacadeService) {
        this.concertFacadeService = concertFacadeService;
    }

    @GetMapping("/available")
    public ResponseEntity<ConcertResponse.GetConcertList> getAvailableConcertList() {
        List<ConcertInfo.V1_GetAvailable> concerts = concertFacadeService.getAvailableConcertList();

        return ResponseEntity.ok(ConcertResponse.GetConcertList.from(concerts));
    }
}
