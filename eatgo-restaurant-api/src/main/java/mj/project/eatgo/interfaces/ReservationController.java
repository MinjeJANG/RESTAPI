package mj.project.eatgo.interfaces;

import io.jsonwebtoken.Claims;
import mj.project.eatgo.application.ReservationService;

import mj.project.eatgo.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public List<Reservation> list(
            Authentication authentication
    ) {
        Claims claims = ((Claims) authentication.getPrincipal());

        Long restauarantId = claims.get("restauarantId", Long.class);
        Long restaurantId = 1004L;

        List<Reservation> reservations = reservationService.getReservations(restaurantId);

        return reservations;

    }
}
