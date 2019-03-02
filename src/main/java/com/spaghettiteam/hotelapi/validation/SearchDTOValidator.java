package com.spaghettiteam.hotelapi.validation;

import com.spaghettiteam.hotelapi.dto.SearchDTO;
import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.dto.TwoPriceSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchDTOValidator implements Validator<SearchDTO> {

    @Autowired
    private TwoDatesSearchValidator twoDatesSearchValidator;
    @Autowired
    private TwoPricesSearchValidator twoPricesSearchValidator;

    @Override
    public void validate(SearchDTO searchDTO) {
        TwoDatesSearch twoDatesSearch = new TwoDatesSearch(searchDTO.getStartDate(), searchDTO.getEndDate());
        twoDatesSearchValidator.validate(twoDatesSearch);
        TwoPriceSearch twoPriceSearch = new TwoPriceSearch(searchDTO.getLowestPrice(), searchDTO.getHighestPrice());
        twoPricesSearchValidator.validate(twoPriceSearch);
    }
}
