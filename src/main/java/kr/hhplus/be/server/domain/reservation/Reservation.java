package kr.hhplus.be.server.domain.reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import kr.hhplus.be.server.domain.concertSchedule.ConcertScheduleId;
import kr.hhplus.be.server.domain.user.UserId;
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
  private LocalDateTime createdAt;

  @Embedded
  private ConcertScheduleId concertScheduleId;

  @Embedded
  private UserId userId;

  public Reservation(ReservationStatus status, ConcertScheduleId concertScheduleId, UserId userId) {
    this.status = status;
    this.concertScheduleId = concertScheduleId;
    this.createdAt = LocalDateTime.now();
    this.userId = userId;
  }

}
