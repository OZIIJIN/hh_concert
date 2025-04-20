package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.payment.PaymentCommand.Pay;
import kr.hhplus.be.server.domain.reservation.Reservation;
import kr.hhplus.be.server.domain.reservation.ReservationId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentFacadeService {

  private final PaymentService paymentService;
  private final WalletService walletService;
  private final ReservationService reservationService;
  private final QueueTokenService queueTokenService;

  public PaymentFacadeService(PaymentService paymentService, WalletService walletService,
      ReservationService reservationService, QueueTokenService queueTokenService) {
    this.paymentService = paymentService;
    this.walletService = walletService;
    this.reservationService = reservationService;
    this.queueTokenService = queueTokenService;
  }

  @Transactional
  public void payForReservation(Pay cmd) {
    Reservation reservation = reservationService.findById(cmd.reservationId().getValue());
    walletService.pay(reservation.getUserId(), cmd.totalPrice());
    paymentService.savePayment(new ReservationId(reservation.getId()), cmd.totalPrice());
    reservationService.toConfirm(reservation);
    queueTokenService.exitAfterPayment(reservation.getUserId());
    queueTokenService.enterNext();
  }
}
