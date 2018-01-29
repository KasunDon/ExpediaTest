package com.expedia.flightsearch.domain;

import com.expedia.flightsearch.domain.entity.Flight;
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlightDepartureFilterTest extends TestCase {

    FlightDepartureFilter flightDepartureFilter;

    public void setUp() throws Exception {

        flightDepartureFilter = new FlightDepartureFilter();

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("ABC", LocalTime.of(18, 30)));
        flights.add(new Flight("DEF", LocalTime.of(7, 50)));
        flights.add(new Flight("LLK", LocalTime.of(6, 45)));
        flights.add(new Flight("HJK", LocalTime.of(20, 10)));
        flights.add(new Flight("XCV", LocalTime.of(12, 30)));
        flights.add(new Flight("BBN", LocalTime.of(14, 20)));

        flightDepartureFilter.setFlights(flights);

        super.setUp();
    }

    @Test
    public void testIllegalStateExceptionWhenFlightsNotSet() {

        boolean thrown = false;

        try {
            flightDepartureFilter.setFlights(null);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertEquals(true, thrown);

        // ----------------------------------------------- //

        thrown = false;

        LocalTime searchTime = LocalTime.of(10, 30);

        try {
            new FlightDepartureFilter().filter(searchTime);
        } catch (IllegalStateException e) {
            thrown = true;
        }

        assertEquals(true, thrown);
    }

    @Test
    public void testFinderShouldDisplayFlightsWithinMinusFiveHourOrPlusFiveHours() {
        LocalTime searchTime = LocalTime.of(10, 30);

        List<Flight> flights = flightDepartureFilter.filter(searchTime);

        assertEquals(4, flights.size());

        Flight flight1 = flights.get(0);

        assertEquals("DEF", flight1.getCarrier());
        assertEquals(LocalTime.of(7, 50), flight1.getDeparture());

        Flight flight2 = flights.get(1);

        assertEquals("LLK", flight2.getCarrier());
        assertEquals(LocalTime.of(6, 45), flight2.getDeparture());

        Flight flight3 = flights.get(2);

        assertEquals("XCV", flight3.getCarrier());
        assertEquals(LocalTime.of(12, 30), flight3.getDeparture());

        Flight flight4 = flights.get(3);

        assertEquals("BBN", flight4.getCarrier());
        assertEquals(LocalTime.of(14, 20), flight4.getDeparture());
    }
}