package kr.hhplus.be.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "concert_schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertSchedule {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime startTime;

  @Column(nullable = false)
  private LocalDateTime endTime;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "concert_id", nullable = false)
  private Concert concert;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "concert_hall_id", nullable = false)
  private ConcertHall concertHall;

  public ConcertSchedule(LocalDateTime startTime, LocalDateTime endTime, Concert concert,
      ConcertHall concertHall) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.concert = concert;
    this.concertHall = concertHall;
  }
}
