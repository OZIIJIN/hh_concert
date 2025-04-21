package kr.hhplus.be.server.presentation.res;

import java.util.UUID;
import kr.hhplus.be.server.application.info.QueueTokenInfo;

public class QueueTokenResponse {

  public record V1_Issue(
      UUID issuedToken
  ) {
    public static V1_Issue from(UUID issuedToken){
      return new V1_Issue(issuedToken);
    }
  }

  public record V1_GetPosition(
      int myPosition,
      int currentPosition
  ) {
    public static V1_GetPosition from(QueueTokenInfo.QueueTokenDetail info) {
      return new V1_GetPosition(info.myPosition(), info.currentPosition());
    }
  }

}
