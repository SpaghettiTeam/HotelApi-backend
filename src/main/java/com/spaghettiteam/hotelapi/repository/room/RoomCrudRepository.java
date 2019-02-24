package com.spaghettiteam.hotelapi.repository.room;

import com.spaghettiteam.hotelapi.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface RoomCrudRepository extends CrudRepository<Room, Long> {

    @Query(value = "select r from Room r where (r.id not in " +
            "(select distinct room from Reservation re " +
            "where (:start >= re.startDate AND :start < re.endDate) OR (:end >= re.startDate AND :end < re.endDate)" +
            "OR (:start < re.startDate AND :end > re.endDate))) " +
            "and r.pricePerDay between :lowestPrice and :highestPrice")
    List<Room> findAvailableRooms(@Param("lowestPrice") double lowestPrice, @Param("highestPrice") double highestPrice,
                                  @Param("start") LocalDate startDate, @Param("end") LocalDate endDate);

    Optional<Room> findByRoomNumber(String roomNumber);

    List<Room> findAllByPricePerDayGreaterThanEqualAndPricePerDayIsLessThanEqual(long lowestPrice, long highestPrice);
}
