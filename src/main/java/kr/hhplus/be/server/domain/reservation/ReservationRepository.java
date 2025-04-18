package kr.hhplus.be.server.domain.reservation;

import java.util.List;

public interface ReservationRepository {

  int countReservedSeats(Long concertScheduleId);

  boolean existsAny(Long aLong, List<Long> seats);

  Reservation saveReservation(Reservation reservation);

  Reservation findById(Long reservationId);
}
