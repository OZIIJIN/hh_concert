package kr.hhplus.be.server.domain.concert;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertId implements Serializable {

  @Column(name = "concert_id")
  private Long value;

  public ConcertId(Long value) {
    if (value == null || value <= 0) {
      throw new IllegalArgumentException("ConcertId must be positive");
    }
    this.value = value;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ConcertId)) return false;
    ConcertId that = (ConcertId) o;
    return value.equals(that.value);
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }

  @Override
  public String toString() {
    return "ConcertId{" + value + '}';
  }

}
