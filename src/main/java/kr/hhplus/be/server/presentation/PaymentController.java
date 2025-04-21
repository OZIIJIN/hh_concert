package kr.hhplus.be.server.presentation;

import kr.hhplus.be.server.application.facade.PaymentFacadeService;
import kr.hhplus.be.server.presentation.req.PaymentRequest.V1_PayReservation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

  private final PaymentFacadeService paymentFacadeService;

  public PaymentController(PaymentFacadeService paymentFacadeService) {
    this.paymentFacadeService = paymentFacadeService;
  }

  @PostMapping("/api/v1/payments")
  public ResponseEntity<Void> createPayment(@RequestBody V1_PayReservation req) {
    paymentFacadeService.payForReservation(req.toCommand());

    return ResponseEntity.ok().build();
  }
}
