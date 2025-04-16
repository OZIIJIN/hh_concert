package kr.hhplus.be.server.presentation;

import java.time.LocalDateTime;
import kr.hhplus.be.server.application.ConcertInfo;
import kr.hhplus.be.server.application.ConcertInfo.V1_GetAvailable;
import kr.hhplus.be.server.domain.concert.Concert;

import java.util.List;

public class ConcertResponse {

    public record GetConcertDetail(
            Long concertId,
            String concertTitle,
            String concertArtist,
            String concertHallName,
            String concertHallLocation,
            LocalDateTime concertStartTime,
            LocalDateTime concertEndTime,
            int availableSeatsCount
    ) {
        public static GetConcertDetail from(ConcertInfo.V1_GetAvailable concertInfo) {
            return new GetConcertDetail(
                concertInfo.concertId(), concertInfo.concertTitle(), concertInfo.concertArtist(),
                concertInfo.concertHallName(), concertInfo.concertHallLocation(),
                concertInfo.concertStartTime(), concertInfo.concertEndTime(),
                concertInfo.availableSeatsCount()
            );
        }
    }

    public record GetConcertList(
            List<GetConcertDetail> concerts
    ) {
        public static GetConcertList from(List<V1_GetAvailable> concertList) {
            return new GetConcertList(
                concertList.stream().map(GetConcertDetail::from).toList()
            );
        }
    }
}
