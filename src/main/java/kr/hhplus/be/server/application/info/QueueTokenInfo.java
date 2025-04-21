package kr.hhplus.be.server.application.info;

public class QueueTokenInfo {
  public record QueueTokenDetail(
      int myPosition,
      int currentPosition
  ) {

  }
}
