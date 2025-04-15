package kr.hhplus.be.server.domain.concertSchedule;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import kr.hhplus.be.server.domain.concert.ConcertId;
import kr.hhplus.be.server.domain.concertHall.ConcertHallId;
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

  @Embedded
  private ConcertId concertId;

  @Embedded
  private ConcertHallId concertHallId;

  public ConcertSchedule(LocalDateTime startTime, LocalDateTime endTime, ConcertId concertId,
      ConcertHallId concertHallId) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.concertId = concertId;
    this.concertHallId = concertHallId;
  }
}
