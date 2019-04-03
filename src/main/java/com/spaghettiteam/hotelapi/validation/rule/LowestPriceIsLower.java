package com.spaghettiteam.hotelapi.validation.rule;

import com.spaghettiteam.hotelapi.dto.TwoPriceSearch;

public class LowestPriceIsLower implements Rule<TwoPriceSearch> {

    @Override
    public void validate(TwoPriceSearch twoPriceSearch) {
        if(twoPriceSearch.getLowestPrice() > twoPriceSearch.getHighestPrice())
            throw new IllegalArgumentException("Pierwsza cena nie moze byc wieksza od drugiej");
    }
}
