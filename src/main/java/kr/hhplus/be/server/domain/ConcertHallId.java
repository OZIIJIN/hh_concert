package kr.hhplus.be.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertHallId implements Serializable {

  @Column(name = "concert_hall_id")
  private Long value;

  public ConcertHallId(Long value) {
    if (value == null || value <= 0) {
      throw new IllegalArgumentException("ConcertHallId must be positive");
    }
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ConcertHallId)) return false;
    ConcertHallId that = (ConcertHallId) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public String toString() {
    return "ConcertHallId{" + value + '}';
  }

}
