package kr.hhplus.be.server.domain.reservation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import kr.hhplus.be.server.domain.concertHall.SeatId;
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

  @Column
  private LocalDateTime expiresAt;

  @Embedded
  private ConcertScheduleId concertScheduleId;

  @Embedded
  private UserId userId;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ReservedSeat> reservedSeats = new ArrayList<>();

  private Reservation(ReservationStatus status, ConcertScheduleId concertScheduleId,
      UserId userId) {
    this.status = status;
    this.concertScheduleId = concertScheduleId;
    this.createdAt = LocalDateTime.now();
    this.userId = userId;
    this.expiresAt = createdAt.plusMinutes(5);
  }

  public static Reservation create(ConcertScheduleId concertScheduleId, UserId userId) {
    return new Reservation(ReservationStatus.PENDING, concertScheduleId, userId);
  }

  public void reserveSeats(List<SeatId> seatIds) {
    this.reservedSeats.clear();
    for (SeatId seatId : seatIds) {
      this.reservedSeats.add(ReservedSeat.create(seatId, concertScheduleId));
    }
  }

  public void confirm() {
    if (this.isExpired()) {
      throw new IllegalStateException("이미 만료된 예약입니다.");
    }
    this.status = ReservationStatus.CONFIRMED;
  }

  public boolean isExpired() {
    return LocalDateTime.now().isAfter(this.expiresAt);
  }

  public void expire() {
    if (this.status == ReservationStatus.PENDING && isExpired()) {
      this.status = ReservationStatus.CANCELLED;
    }
  }

}
