package com.expedia.flightsearch.domain.validator;

public class DepartureTimeParameterValidator implements InputParameterValidator<String> {

    public void validate(
        String parameter
    ) {

        if (parameter == null) {
            throw new IllegalStateException("departureTime cannot be null.");
        }

        if (parameter.isEmpty()) {
            throw new IllegalStateException("departureTime cannot be empty.");
        }

    }
}
