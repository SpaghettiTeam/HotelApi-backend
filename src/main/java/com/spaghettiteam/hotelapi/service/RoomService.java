package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.dto.RoomDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.exception.RoomAlreadyExistException;
import com.spaghettiteam.hotelapi.exception.RoomNotFoundException;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.repository.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room findById(long id) {
        return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }

    private Room findByRoomNumber(String roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber).orElseThrow(RoomNotFoundException::new);
    }

    //ToDo refactore, looks bad
    public Room addRoom(RoomDTO room) {
        try {
            findByRoomNumber(room.getRoomNumber());
        } catch (RoomNotFoundException e) {
            return roomRepository.save(new Room(room.getRoomNumber()));
        }
        throw new RoomAlreadyExistException();
    }


    private long countDaysFromTwoDatesSearch(TwoDatesSearch twoDatesSearch) {
        return DAYS.between(twoDatesSearch.getStartDate(), twoDatesSearch.getStartDate());
    }
}
