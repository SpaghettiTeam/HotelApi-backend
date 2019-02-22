package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.ReservationDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesAndTwoPriceSearch;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/api/reservation/{id}")
    public Reservation getReservationId(@PathVariable("id") long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping("/api/reservation/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/api/reservation/room/{roomNumber}")
    public List<Reservation> getAllReservationsByRoomNumber(@PathVariable("roomNumber") long roomNumber) {
        return reservationService.getAllByReservationsByRoomNumber(roomNumber);
    }

    @DeleteMapping("/api/reservation/{id}")
    public Reservation deleteReservationId(@PathVariable("id") long id) {
        return reservationService.deleteReservationById(id);
    }

    @PostMapping("/api/reservation/{id}")
    public Reservation updateReservationId(@PathVariable("id") long id, @RequestBody Reservation reservation) {
        return reservationService.updateReservationById(id, reservation);
    }

    @PostMapping("/api/reservation/add")
    public Reservation addReservation(@RequestBody ReservationDTO reservation) {
        return reservationService.addReservation(reservation);
    }
}
