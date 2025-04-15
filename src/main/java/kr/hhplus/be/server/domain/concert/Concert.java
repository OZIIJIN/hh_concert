package kr.hhplus.be.server.domain.concert;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "concerts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Concert {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(nullable = false)
  String title;

  @Column(nullable = false)
  String artist;

  public Concert(String title, String artist) {
    this.title = title;
    this.artist = artist;
  }
}
