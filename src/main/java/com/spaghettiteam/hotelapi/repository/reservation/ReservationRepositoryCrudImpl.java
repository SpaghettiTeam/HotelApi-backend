package com.spaghettiteam.hotelapi.repository.reservation;

import com.spaghettiteam.hotelapi.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepositoryCrudImpl implements ReservationRepository {

    @Autowired
    private ReservationCrudRepository repository;

    @Override
    public List<Reservation> findAllAvaibleRoomsBetweendDates(LocalDate startDate, LocalDate endDate) {
        return repository.findAllAvaibleRoomsBetweendDates(startDate, endDate);
    }

    @Override
    public List<Reservation> findAllByRoomNumber(long roomNumber) {
        return repository.findAllByRoom(roomNumber);
    }

    @Override
    public void updateById(long id, Reservation reservation) {
        deleteById(id);
        save(reservation);
    }

    @Override
    public Optional<Reservation> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return (List) repository.findAll();
    }

    @Override
    public Reservation save(Reservation reservation) {
        return repository.save(reservation);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Deprecated
    @Override
    public List<Reservation> findAllAvaibleRoomsBetweendDatesAndWithinPrice(LocalDate startDate, LocalDate endDate, double lowestPriceMuliplied, double highestPriceMultiplied) {
        return null;
    }
}
