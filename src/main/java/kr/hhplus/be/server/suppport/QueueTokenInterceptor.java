package kr.hhplus.be.server.suppport;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;
import kr.hhplus.be.server.application.QueueTokenService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class QueueTokenInterceptor implements HandlerInterceptor {

  private final QueueTokenService queueTokenService;

  public QueueTokenInterceptor(QueueTokenService queueTokenService) {
    this.queueTokenService = queueTokenService;
  }

  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
      throws Exception {

    String tokenIdHeader = req.getHeader("X-Queue-Token");

    if (tokenIdHeader == null) {
      res.sendError(HttpStatus.UNAUTHORIZED.value(), "대기열 토큰이 필요합니다.");
      return false;
    }

    try {
      UUID tokenId = UUID.fromString(tokenIdHeader);
      queueTokenService.validate(tokenId);
      return true;
    } catch (IllegalArgumentException e) {
      res.sendError(HttpStatus.FORBIDDEN.value(), e.getMessage());
      return false;
    }

  }

}
