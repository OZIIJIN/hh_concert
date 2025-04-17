package kr.hhplus.be.server.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserId {

  @Column(name = "user_id", nullable = false, updatable = false, columnDefinition = "BINARY(16)")
  private UUID value;

  public UserId(UUID value) {
    if (value == null) {
      throw new IllegalArgumentException("UserId must not be null");
    }
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UserId)) return false;
    UserId that = (UserId) o;
    return Objects.equals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "UserId{" + value + '}';
  }

}
