package com.spaghettiteam.hotelapi.validation.rule;

import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;

public class StartDateBeforeEndDateRule implements Rule<TwoDatesSearch> {

    @Override
    public void validate(TwoDatesSearch twoDatesSearch) {
        if(twoDatesSearch.getStartDate().isAfter(twoDatesSearch.getEndDate()))
            throw new IllegalArgumentException("StartDate is after EndDate!");
    }
}
