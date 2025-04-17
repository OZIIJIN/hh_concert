package kr.hhplus.be.server.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "users")
public class User {

  @Id
  @Column(updatable = false, nullable = false, columnDefinition = "BINARY(16)")
  private UUID id;

  protected User() {
    this.id = UUID.randomUUID();
  }

  public static User create() {
    return new User();
  }

}
