package com.spaghettiteam.hotelapi.validation.validator;

import com.spaghettiteam.hotelapi.dto.TwoDatesSearch;
import com.spaghettiteam.hotelapi.validation.rule.Rule;
import com.spaghettiteam.hotelapi.validation.rule.StartDateBeforeEndDateRule;
import com.spaghettiteam.hotelapi.validation.rule.DateIsPastRule;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

@Component
public class TwoDatesSearchValidator implements Validator<TwoDatesSearch> {

    private Collection<Rule<TwoDatesSearch>> twoDatesSerachRules = new LinkedList<>();
    private Collection<Rule<LocalDate>> localDataRules = new LinkedList<>();

    @Override
    public void validate(TwoDatesSearch twoDatesSearches) {
        twoDatesSerachRules.add(new StartDateBeforeEndDateRule());
        localDataRules.add(new DateIsPastRule());
        localDataRules.add(new DateIsPastRule());
        for (Rule<TwoDatesSearch> r :
             twoDatesSerachRules) {
            r.validate(twoDatesSearches);
        }
        for (Rule<LocalDate> r:
             localDataRules) {
            r.validate(twoDatesSearches.getStartDate());
            r.validate(twoDatesSearches.getEndDate());
        }
    }
}
