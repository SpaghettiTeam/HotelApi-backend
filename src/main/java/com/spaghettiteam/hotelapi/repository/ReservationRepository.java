package com.spaghettiteam.hotelapi.repository;

import com.spaghettiteam.hotelapi.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query(value = "select r from Room r where r.id not in " +
            "(select distinct room from Reservation re " +
            "where (:start >= re.startDate OR :start < re.endDate) OR (:end >= re.startDate OR :end < re.endDate))")
    List<Reservation> findAllByStartDateAndEndDate(@Param("start") LocalDate startDate,@Param("end") LocalDate endDate);

}
