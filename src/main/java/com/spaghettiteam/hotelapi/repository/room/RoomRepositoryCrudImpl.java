package com.spaghettiteam.hotelapi.repository.room;

import com.spaghettiteam.hotelapi.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepositoryCrudImpl implements RoomRepository {

    @Autowired
    private RoomCrudRepository roomCrudRepository;

    @Override
    public List<Room> findAvailableRooms(double lowestPrice, double highestPrice, LocalDate startDate, LocalDate endDate) {
        return roomCrudRepository.findAvailableRooms(lowestPrice, highestPrice, startDate, endDate);
    }

    @Override
    public Optional<Room> findByRoomNumber(String roomNumber) {
        return roomCrudRepository.findByRoomNumber(roomNumber);
    }

    @Override
    public List<Room> findAll() {
        return (List<Room>)roomCrudRepository.findAll();
    }

    @Override
    public Optional<Room> findById(long id) {
        return roomCrudRepository.findById(id);
    }

    @Override
    public Room save(Room room) {
        Room roomToReturn;
        try {
            roomToReturn = roomCrudRepository.save(room);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Room> findRoomsWithinPrice(long startPrice, long endPrice) {
        return roomCrudRepository.findAllByPricePerDayGreaterThanEqualAndPricePerDayIsLessThanEqual(startPrice, endPrice);
    }

    @Override
    public void updateById(long id, Room newRoom) {
        deleteById(id);
        save(newRoom);
    }

    @Override
    public void deleteById(long id) {
        roomCrudRepository.deleteById(id);
    }
}
