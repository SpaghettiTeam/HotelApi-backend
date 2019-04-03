package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.dto.SearchDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesAndTwoPriceSearch;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.exception.RoomNotFoundException;
import com.spaghettiteam.hotelapi.model.Reservation;
import com.spaghettiteam.hotelapi.model.Room;
import com.spaghettiteam.hotelapi.repository.reservation.ReservationRepository;
import com.spaghettiteam.hotelapi.repository.room.RoomRepository;
import com.spaghettiteam.hotelapi.validation.validator.SearchDTOValidator;
import com.spaghettiteam.hotelapi.validation.validator.TwoDatesSearchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class SearchService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SearchDTOValidator searchDTOValidator;
    @Autowired
    private TwoDatesSearchValidator twoDatesSearchValidator;
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Room> findRooms(SearchDTO search) {
        searchDTOValidator.validate(search);
        double lowestPrice = search.getLowestPrice();
        double highestPrice = search.getHighestPrice();
        LocalDate startDate = search.getStartDate();
        LocalDate endDate = search.getEndDate();
        return roomRepository.findAvailableRooms(lowestPrice, highestPrice, startDate, endDate);
    }

    @Deprecated
    public List<Reservation> findAvailableRoomsBetweenDates(TwoDatesSearch twoDatesSearch) {
        twoDatesSearchValidator.validate(twoDatesSearch);
        return reservationRepository.findAllAvaibleRoomsBetweendDates(twoDatesSearch.getStartDate(), twoDatesSearch.getEndDate());
    }

    @Deprecated
    public List<Reservation> findAvailableRoomsBetweenDatesAndPrices(TwoDatesAndTwoPriceSearch twoDatesAndTwoPriceSearch) {
//        twoDatesAndTwoPriceSearchValidator.validate(twoDatesAndTwoPriceSearch);
        long days = countDaysFromTwoDatesSearch(twoDatesAndTwoPriceSearch.getTwoDates());
        double lowestPriceMuliplied = twoDatesAndTwoPriceSearch.getTwoPrices().getLowestPrice() * days;
        double highestPriceMultiplied = twoDatesAndTwoPriceSearch.getTwoPrices().getHighestPrice() * days;
        return reservationRepository.findAllAvaibleRoomsBetweendDatesAndWithinPrice(
                twoDatesAndTwoPriceSearch.getTwoDates().getStartDate(), twoDatesAndTwoPriceSearch.getTwoDates().getEndDate(),
                lowestPriceMuliplied, highestPriceMultiplied);
    }

    @Deprecated
    public List<Room> findRoomsWithinPrice(long startPrice, long endPrice) {
        List<Room> rooms = roomRepository.findRoomsWithinPrice(startPrice, endPrice);
        if (rooms != null)
            return rooms;
        throw new RoomNotFoundException();
    }

    private long countDaysFromTwoDatesSearch(TwoDatesSearch twoDatesSearch) {
        return DAYS.between(twoDatesSearch.getStartDate(), twoDatesSearch.getStartDate());
    }
}
