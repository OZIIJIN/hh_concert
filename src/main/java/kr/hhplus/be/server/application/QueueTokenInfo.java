package kr.hhplus.be.server.application;

public class QueueTokenInfo {
  public record QueueTokenDetail(
      int myPosition,
      int currentPosition
  ) {

  }
}
