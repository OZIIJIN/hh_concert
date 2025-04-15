package kr.hhplus.be.server.domain.reservation;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import kr.hhplus.be.server.domain.concertHall.SeatId;
import kr.hhplus.be.server.domain.concertSchedule.ConcertScheduleId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(
    name = "reserved_seats",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"seat_id", "concert_schedule_id"})
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservedSeat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  private SeatId seatId;

  @Embedded
  private ConcertScheduleId concertScheduleId;

  public ReservedSeat(SeatId seatId, ConcertScheduleId concertScheduleId) {
    this.seatId = seatId;
    this.concertScheduleId = concertScheduleId;
  }
}
