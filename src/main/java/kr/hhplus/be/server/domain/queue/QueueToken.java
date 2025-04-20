package kr.hhplus.be.server.domain.queue;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import kr.hhplus.be.server.domain.user.UserId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "queue_tokens")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QueueToken {

  @Id
  @Column(columnDefinition = "BINARY(16)")
  private UUID id;

  @Embedded
  private UserId userId;

  @Column
  private int position;

  @Column
  private LocalDateTime issuedAt;

  @Column
  private LocalDateTime expiresAt;

  @Enumerated(EnumType.STRING)
  private QueueTokenStatus status;

  private QueueToken(UserId userId, int position, LocalDateTime issuedAt, LocalDateTime expiresAt) {
    this.id = UUID.randomUUID();
    this.userId = userId;
    this.position = position;
    this.issuedAt = issuedAt;
    this.expiresAt = expiresAt;
    this.status = QueueTokenStatus.WAITING;
  }

  public static QueueToken issue(UserId userId, int position, Duration ttl) {
    LocalDateTime now = LocalDateTime.now();

    return new QueueToken(userId, position, now, now.plus(ttl));
  }

  public boolean isExpired() {
    return LocalDateTime.now().isAfter(expiresAt);
  }

  public boolean isAccessible(int currentPosition) {
    return this.status == QueueTokenStatus.WAITING && this.position == currentPosition;
  }

  public void toEntered() {
    this.status = QueueTokenStatus.ENTERED;
  }

  public void toExited() {
    this.status = QueueTokenStatus.EXITED;
  }

  public void toExpired() {
    this.status = QueueTokenStatus.EXPIRED;
  }
}
