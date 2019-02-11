package com.spaghettiteam.hotelapi.repository.room;

import com.spaghettiteam.hotelapi.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    Optional<Room> findByRoomNumber(String roomNumber);
    Optional<Room> findById(long id);
    Room save(Room room);
    List<Room> findRoomsWithinPrice(long startPrice, long endPrice);
}
