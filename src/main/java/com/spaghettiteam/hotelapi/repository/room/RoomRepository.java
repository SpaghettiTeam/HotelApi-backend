package com.spaghettiteam.hotelapi.repository.room;

import com.spaghettiteam.hotelapi.model.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    Optional<Room> findByRoomNumber(String roomNumber);

    Optional<Room> findById(long id);

    Room save(Room room);

    void deleteById(long id);

    List<Room> findRoomsWithinPrice(long startPrice, long endPrice);

    List<Room> findAvailableRooms(double lowestPrice, double highestPrice, LocalDate startDate, LocalDate endDate);

    void updateById(long id, Room newRoom);

    List<Room> findAll();
}
