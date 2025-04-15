package kr.hhplus.be.server.domain.reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import kr.hhplus.be.server.domain.concertSchedule.ConcertScheduleId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "reservations")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private ReservationStatus status;

  @Column
  private LocalDateTime createdAt=LocalDateTime.now();

  @Embedded
  private ConcertScheduleId concertScheduleId;

  public Reservation(ReservationStatus status, ConcertScheduleId concertScheduleId) {
    this.status = status;
    this.concertScheduleId = concertScheduleId;
  }

}
