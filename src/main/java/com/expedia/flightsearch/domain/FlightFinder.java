package com.expedia.flightsearch.domain;

import com.expedia.flightsearch.domain.entity.Flight;
import com.expedia.flightsearch.domain.parser.TimeParser;
import com.expedia.flightsearch.domain.validator.InputParameterValidator;

import java.time.LocalTime;
import java.util.List;

public class FlightFinder {

    private InputParameterValidator<String> inputParameterValidator;
    private TimeParser timeParser;
    private FlightDepartureFilter flightDepartureFilter;

    public FlightFinder(
        InputParameterValidator<String> inputParameterValidator,
        TimeParser timeParser,
        FlightDepartureFilter flightDepartureFilter
    ) {
        this.inputParameterValidator = inputParameterValidator;
        this.timeParser = timeParser;
        this.flightDepartureFilter = flightDepartureFilter;
    }

    public List<Flight> find(
        String departureTime
    ) {
        inputParameterValidator.validate(departureTime);

        LocalTime parsedDepartureTime = timeParser.parse(departureTime);

        return flightDepartureFilter.filter(parsedDepartureTime);
    }
}
