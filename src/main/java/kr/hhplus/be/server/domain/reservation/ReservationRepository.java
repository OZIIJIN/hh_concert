package kr.hhplus.be.server.domain.reservation;

public interface ReservationRepository {

  int countReservedSeats(Long concertScheduleId);
}
