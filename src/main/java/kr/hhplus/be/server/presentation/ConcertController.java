package kr.hhplus.be.server.presentation;

import kr.hhplus.be.server.application.ConcertFacadeService;
import kr.hhplus.be.server.application.ConcertInfo;
import kr.hhplus.be.server.application.ConcertInfo.GetAvailableConcerts;
import kr.hhplus.be.server.domain.concertSchedule.ConcertScheduleCommand;
import kr.hhplus.be.server.presentation.res.ConcertResponse.V1_GetAvailableList;
import kr.hhplus.be.server.presentation.res.ConcertResponse.V1_GetAvailableSeats;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/concerts")
public class ConcertController {

  private final ConcertFacadeService concertFacadeService;

  public ConcertController(ConcertFacadeService concertFacadeService) {
    this.concertFacadeService = concertFacadeService;
  }

  @GetMapping("/concertSchedule")
  public ResponseEntity<V1_GetAvailableList> getAvailableConcertList() {
    List<GetAvailableConcerts> info = concertFacadeService.getAvailableConcertList();

    return ResponseEntity.ok(V1_GetAvailableList.from(info));
  }

  @GetMapping("/concertSchedule/{concertScheduleId}/seats")
  public ResponseEntity<V1_GetAvailableSeats> getAvailableSeats(
      @PathVariable Long concertScheduleId) {
    List<ConcertInfo.GetAvailableSeat> info = concertFacadeService.getAvailableSeats(
        ConcertScheduleCommand.Id.fromId(concertScheduleId));

    return ResponseEntity.ok(V1_GetAvailableSeats.from(info));
  }
}