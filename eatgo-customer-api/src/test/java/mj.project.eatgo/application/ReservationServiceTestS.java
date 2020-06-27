package mj.project.eatgo.application;

import mj.project.eatgo.domain.Reservation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class ReservationServiceTestS {


    private ReservationService reservationService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reservationService = new ReservationService();
    }

    @Test
    public void addReservation() {

        Long restaurantId = 369L;
        Long userId = 1004L;
        String name = "John";
        String date = "2019-12-24";
        String time = "20:00";
        Integer partySize = 20;

        Reservation reservation = reservationService.addReservation(
                restaurantId, userId, name, date, time, partySize);

        assertThat(reservation.getName(), is(name));

        //verify(reservationRepository).save(any(Reservation.class));
    }

}