package com.spaghettiteam.hotelapi.validation.rule;

public interface Rule<T> {
    void validate(T t);
}
