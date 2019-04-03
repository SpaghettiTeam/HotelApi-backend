package com.spaghettiteam.hotelapi.validation.rule;

import java.time.LocalDate;

public class DateIsPastRule implements Rule<LocalDate> {

    @Override
    public void validate(LocalDate localDate) {
        if(localDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Data nie moze byc wczesniejsza!");
    }
}
