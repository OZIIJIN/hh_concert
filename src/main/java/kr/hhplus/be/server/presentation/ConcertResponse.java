package kr.hhplus.be.server.presentation;

import kr.hhplus.be.server.domain.Concert;

import java.time.LocalDate;
import java.util.List;

public class ConcertResponse {

    public record GetConcertDetail(
            Long concertId,
            String concertName,
            String concertLocation,
            LocalDate concertStartDate,
            LocalDate concertEndDate
    ) {
        public static GetConcertDetail from(Concert concert) {
            return new GetConcertDetail(
                    concert.getId(),
                    concert.getName(),
                    concert.getLocation(),
                    concert.getStartDate(),
                    concert.getEndDate());
        }
    }

    public record GetConcertList(
            List<GetConcertDetail> concerts
    ) {
        public static GetConcertList from(List<GetConcertDetail> concerts) {
            return new GetConcertList(concerts);
        }
    }
}
