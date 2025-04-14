## ERD 다이어그램
```mermaid
erDiagram

  CONCERT ||--o{ CONCERT_SCHEDULE : has
  CONCERT_SCHEDULE }o--|| CONCERT_HALL : uses
  CONCERT_HALL ||--o{ SEAT : contains
  CONCERT_SCHEDULE ||--o{ RESERVATION : allows
  RESERVATION ||--o{ RESERVED_SEAT : contains
  SEAT ||--o{ RESERVED_SEAT : is_reserved_by
  CONCERT_SCHEDULE ||--o{ RESERVED_SEAT : has_seat_in
  RESERVATION ||--|| PAYMENT : generates

  CONCERT {
    bigint id PK
    string title
    string artist
  }

  CONCERT_SCHEDULE {
    bigint id PK
    bigint concert_id FK
    bigint concert_hall_id FK
    datetime start_time
    datetime end_time
  }

  CONCERT_HALL {
    bigint id PK
    string name
    string location
  }

  SEAT {
    bigint id PK
    bigint concert_hall_id FK
    string section
    int row
    int number
    string type
  }

  RESERVATION {
    bigint id PK
    bigint user_id
    bigint concert_schedule_id FK
    string status
    datetime created_at
  }

  RESERVED_SEAT {
    bigint id PK
    bigint reservation_id FK
    bigint seat_id FK
    bigint concert_schedule_id FK
  }

  PAYMENT {
    bigint id PK
    bigint reservation_id FK
    int amount
    string status
    string pg_response
    datetime paid_at
  }
