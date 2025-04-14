package kr.hhplus.be.server.presentation;

import kr.hhplus.be.server.domain.Concert;

import java.util.List;

public class ConcertResponse {

    public record GetConcertDetail(
            Long concertId,
            String concertName,
            String concertLocation
    ) {
        public static GetConcertDetail from(Concert concert) {
            return new GetConcertDetail(
                    concert.getId(),
                    concert.getTitle(),
                    concert.getArtist());
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
