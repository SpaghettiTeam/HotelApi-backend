package com.spaghettiteam.hotelapi.repository.reservation;

import com.spaghettiteam.hotelapi.model.Reservation;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    List<Reservation> findAllAvaibleRoomsBetweendDates(@Param("start") LocalDate startDate, @Param("end") LocalDate endDate);

    Reservation save(Reservation reservation);

    List<Reservation> findAllAvaibleRoomsBetweendDatesAndWithinPrice(LocalDate startDate, LocalDate endDate, double lowestPriceMuliplied, double highestPriceMultiplied);

    Optional<Reservation> findById(long id);

    List<Reservation> findAll();

    List<Reservation> findAllByRoomNumber(long roomNumber);

    void deleteById(long id);

    void updateById(long id, Reservation reservation);
}
