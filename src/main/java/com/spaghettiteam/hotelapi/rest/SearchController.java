package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.RoomToSendDTO;
import com.spaghettiteam.hotelapi.dto.SearchDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesAndTwoPriceSearch;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.service.ReservationService;
import com.spaghettiteam.hotelapi.service.SearchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/api/findrooms")
    public List<RoomToSendDTO> findAvailableRooms(@RequestBody SearchDTO searchDTO) {
        List<Room> rooms = searchService.findRooms(searchDTO);
        return rooms.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Deprecated
    @PostMapping("/api/find_rooms1")
    public List<Reservation> getAvailableRoomsBetweenDates(@RequestBody TwoDatesSearch twoDatesSearch) {
        return searchService.findAvailableRoomsBetweenDates(twoDatesSearch);
    }

    @Deprecated
    @PostMapping("/api/find_rooms2")
    public List<Reservation> getAvailableRoomsBewtweenDatesAndWithinPrice(@RequestBody TwoDatesAndTwoPriceSearch twoDatesAndTwoPriceSearch) {
        return searchService.findAvailableRoomsBetweenDatesAndPrices(twoDatesAndTwoPriceSearch);
    }

    private RoomToSendDTO convertToDTO(Room room) {
        return modelMapper.map(room, RoomToSendDTO.class);
    }
}
