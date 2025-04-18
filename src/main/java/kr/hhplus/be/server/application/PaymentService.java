package kr.hhplus.be.server.application;

import kr.hhplus.be.server.domain.payment.Payment;
import kr.hhplus.be.server.domain.payment.PaymentRepository;
import kr.hhplus.be.server.domain.reservation.ReservationId;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  private final PaymentRepository paymentRepository;

  public PaymentService(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  public void savePayment(ReservationId reservationId, int amount) {
    Payment payment = Payment.create(reservationId, amount);

    paymentRepository.save(payment);
  }

}
