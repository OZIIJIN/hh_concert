package kr.hhplus.be.server.presentation.scheduler;

import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import kr.hhplus.be.server.application.QueueTokenService;
import kr.hhplus.be.server.domain.queue.QueueToken;
import kr.hhplus.be.server.domain.queue.QueueTokenRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QueueScheduler {

  private final QueueTokenService queueTokenService;

  public QueueScheduler(
      QueueTokenService queueTokenService) {
    this.queueTokenService = queueTokenService;
  }

  @Scheduled(fixedRate = 60000)
  @Transactional
  public void expireTokens() {
    queueTokenService.findExpiredTokens(LocalDateTime.now())
        .forEach(QueueToken::toExpired);
   queueTokenService.enterNext();
  }

}
