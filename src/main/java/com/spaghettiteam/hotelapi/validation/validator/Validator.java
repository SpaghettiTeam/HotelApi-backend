package com.spaghettiteam.hotelapi.validation.validator;

public interface Validator<T> {
    void validate(T t);
}
