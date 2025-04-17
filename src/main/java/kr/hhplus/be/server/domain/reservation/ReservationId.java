package kr.hhplus.be.server.domain.reservation;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import kr.hhplus.be.server.domain.concert.ConcertId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationId implements Serializable {

  @Column(name = "reservation_id")
  private Long value;

  public ReservationId(Long value) {
    if (value == null || value <= 0) {
      throw new IllegalArgumentException("ReservationId must be positive");
    }
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ReservationId)) return false;
    ReservationId that = (ReservationId) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public String toString() {
    return "ReservationId{" + value + '}';
  }

}
