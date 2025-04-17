package kr.hhplus.be.server.presentation;

import kr.hhplus.be.server.application.ReservationFacadeService;
import kr.hhplus.be.server.application.ReservationInfo;
import kr.hhplus.be.server.domain.reservation.ReservationCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

  private final ReservationFacadeService reservationFacadeService;

  public ReservationController(ReservationFacadeService reservationFacadeService) {
    this.reservationFacadeService = reservationFacadeService;
  }

  @PostMapping("/api/v1/reservations")
  public ResponseEntity<ReservationResponse.V1_Reservation> reservationSeats(
      @RequestBody ReservationRequest.V1_Reservation req) {
    ReservationInfo.Id info = reservationFacadeService.reservationSeats(req.toCommand());

    return ResponseEntity.ok().body(ReservationResponse.V1_Reservation.from(info));
  }
}
