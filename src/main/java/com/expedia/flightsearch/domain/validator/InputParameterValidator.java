package com.expedia.flightsearch.domain.validator;

public interface InputParameterValidator<T> {

    void validate(
        T parameter
    );
}
