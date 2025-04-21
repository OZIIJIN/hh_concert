package kr.hhplus.be.server.presentation;

import java.util.UUID;
import kr.hhplus.be.server.application.QueueTokenInfo;
import kr.hhplus.be.server.application.QueueTokenService;
import kr.hhplus.be.server.domain.user.UserId;
import kr.hhplus.be.server.presentation.res.QueueTokenResponse;
import kr.hhplus.be.server.presentation.res.QueueTokenResponse.V1_Issue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueTokenController {

  private final QueueTokenService queueTokenService;

  public QueueTokenController(QueueTokenService queueTokenService) {
    this.queueTokenService = queueTokenService;
  }

  @PostMapping("/api/v1/queue-tokens")
  public ResponseEntity<V1_Issue> issue(@RequestBody UUID userId) {
    UUID queueToken = queueTokenService.issueToken(new UserId(userId));

    return ResponseEntity.ok(QueueTokenResponse.V1_Issue.from(queueToken));
  }

  @GetMapping("/api/v1/queue-tokens/")
  public ResponseEntity<QueueTokenResponse.V1_GetPosition> getPosition(@RequestParam UUID userId) {
    QueueTokenInfo.QueueTokenDetail info = queueTokenService.getMyPosition(new UserId(userId));

    return ResponseEntity.ok(QueueTokenResponse.V1_GetPosition.from(info));
  }
}
