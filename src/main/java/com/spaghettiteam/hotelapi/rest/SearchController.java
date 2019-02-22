package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.dto.SearchDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesAndTwoPriceSearch;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.service.ReservationService;
import com.spaghettiteam.hotelapi.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/api/findrooms")
    public List<Room> findAvailableRooms(@RequestBody SearchDTO searchDTO) {
        return searchService.findRooms(searchDTO);
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
}
