package com.expedia.flightsearch.domain;

import com.expedia.flightsearch.domain.entity.Flight;
import com.expedia.flightsearch.domain.parser.StringToLocalTimeParser;
import com.expedia.flightsearch.domain.parser.TimeParser;
import com.expedia.flightsearch.domain.validator.DepartureTimeParameterValidator;
import com.expedia.flightsearch.domain.validator.InputParameterValidator;
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFinderTest extends TestCase {

    private FlightFinder flightFinder;

    public void setUp() throws Exception {

        InputParameterValidator<String> inputParameterValidator = new DepartureTimeParameterValidator();
        TimeParser timeParser = new StringToLocalTimeParser();
        FlightDepartureFilter flightDepartureFilter = new FlightDepartureFilter();

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("ABC", LocalTime.of(18, 30)));
        flights.add(new Flight("DEF", LocalTime.of(7, 50)));
        flights.add(new Flight("LLK", LocalTime.of(6, 45)));
        flights.add(new Flight("HJK", LocalTime.of(20, 10)));
        flights.add(new Flight("XCV", LocalTime.of(12, 30)));
        flights.add(new Flight("BBN", LocalTime.of(14, 20)));

        flightDepartureFilter.setFlights(flights);

        flightFinder = new FlightFinder(inputParameterValidator, timeParser, flightDepartureFilter);

        super.setUp();
    }

    @Test
    public void testFindMatchingFlightByDepartureTime() {
        String departureTime = "6:00AM";

        List<Flight> flights = flightFinder.find(departureTime);

        assertEquals(2, flights.size());
    }

}