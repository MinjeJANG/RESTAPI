package mj.project.eatgo.application;

import mj.project.eatgo.domain.Reservation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {

    public Reservation addReservation(Long restaurantId, Long userId, String name, String date, String time, Integer partSize) {

        return Reservation.builder()
                .restaurantId(restaurantId)
                .userId(userId)
                .name(name)
                .date(date)
                .time(time)
                .partySize(partSize)
                .build();
    }
}
