package kr.hhplus.be.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(
    name = "seats",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"concert_hall_id", "number"})
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private int number;

  @ManyToOne
  @JoinColumn(name = "concert_hall_id", nullable = false)
  private ConcertHall concertHall;

  public Seat(int number, ConcertHall concertHall) {
    this.number = number;
    this.concertHall = concertHall;
  }
}
