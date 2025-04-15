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
public class ConcertScheduleId implements Serializable {

  @Column(name = "concert_schedule_id")
  private Long value;

  public ConcertScheduleId(Long value) {
    if (value == null || value <= 0) {
      throw new IllegalArgumentException("ConcertScheduleId must be positive");
    }
    this.value = value;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ConcertScheduleId)) return false;
    ConcertScheduleId that = (ConcertScheduleId) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public String toString() {
    return "ConcertScheduleId{" + value + '}';
  }
}
