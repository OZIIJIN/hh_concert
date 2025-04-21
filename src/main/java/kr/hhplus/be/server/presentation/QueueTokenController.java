package kr.hhplus.be.server.presentation;

import java.util.UUID;
import kr.hhplus.be.server.application.info.QueueTokenInfo;
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
  public ResponseEntity<V1_Issue> issue(@RequestBody String userId) {
    UUID queueToken = queueTokenService.issueToken(new UserId(UUID.fromString(userId)));

    return ResponseEntity.ok(QueueTokenResponse.V1_Issue.from(queueToken));
  }

  @GetMapping("/api/v1/queue-tokens")
  public ResponseEntity<QueueTokenResponse.V1_GetPosition> getPosition(
      @RequestParam String userId) {
    QueueTokenInfo.QueueTokenDetail info = queueTokenService.getMyPosition(
        new UserId(UUID.fromString(userId)));

    return ResponseEntity.ok(QueueTokenResponse.V1_GetPosition.from(info));
  }
}
