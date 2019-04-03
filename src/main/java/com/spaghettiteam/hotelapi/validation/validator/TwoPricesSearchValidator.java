package com.spaghettiteam.hotelapi.validation.validator;

import com.spaghettiteam.hotelapi.dto.TwoPriceSearch;
import com.spaghettiteam.hotelapi.validation.rule.Rule;
import com.spaghettiteam.hotelapi.validation.rule.LowestPriceIsLower;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;

@Component
public class TwoPricesSearchValidator implements Validator<TwoPriceSearch> {

    private Collection<Rule<TwoPriceSearch>> twoPriceSearchRules = new LinkedList<>();

    @Override
    public void validate(TwoPriceSearch twoPriceSearch) {
        twoPriceSearchRules.add(new LowestPriceIsLower());
        for (Rule<TwoPriceSearch> r:
                twoPriceSearchRules) {
            r.validate(twoPriceSearch);
        }
    }
}
