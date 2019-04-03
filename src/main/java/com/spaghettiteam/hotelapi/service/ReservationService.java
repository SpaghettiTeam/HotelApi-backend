package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.dto.ReservationDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.exception.ReservationNotFoundException;
import com.spaghettiteam.hotelapi.exception.RoomNotFoundException;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.model.User;
import com.spaghettiteam.hotelapi.repository.reservation.ReservationRepository;
import com.spaghettiteam.hotelapi.validation.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;

    @Autowired
    private Validator<TwoDatesSearch> twoDatesSearchValidator;

    public Reservation getReservationById(long id) {
        return reservationRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation updateReservationById(long id, Reservation newReservation) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(ReservationNotFoundException::new);
        reservationRepository.updateById(id, newReservation);
        return reservation;
    }

    public Reservation deleteReservationById(long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(ReservationNotFoundException::new);
        reservationRepository.deleteById(id);
        return reservation;
    }

    public List<Reservation> getAllByReservationsByRoomNumber(long roomNumber) {
        return reservationRepository.findAllByRoomNumber(roomNumber);
    }

    public Reservation addReservation(ReservationDTO reservationDTO) {
        twoDatesSearchValidator.validate(new TwoDatesSearch(reservationDTO.getStartDate(), reservationDTO.getEndDate()));
        return reservationRepository.save(Reservation.ReservationBuilder.aReservation()
                .withUser(new User())
                .withRoom(roomService.findById(reservationDTO.getRoomId()))
                .withStartDate(reservationDTO.getStartDate())
                .build());
    }
}
