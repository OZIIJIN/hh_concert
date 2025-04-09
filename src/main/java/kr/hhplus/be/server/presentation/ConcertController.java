package kr.hhplus.be.server.presentation;

import kr.hhplus.be.server.application.ConcertFacadeService;
import kr.hhplus.be.server.domain.Concert;
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
        List<Concert> concerts = concertFacadeService.getAvailableConcertList();

        List<ConcertResponse.GetConcertDetail> concertDetails = new ArrayList<>();

        for (Concert concert : concerts) {
            ConcertResponse.GetConcertDetail concertDetail = ConcertResponse.GetConcertDetail.from(concert);
            concertDetails.add(concertDetail);
        }

        return ResponseEntity.ok(ConcertResponse.GetConcertList.from(concertDetails));
    }
}
