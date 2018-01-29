package com.expedia.flightsearch.domain.entity;

import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalTime;

public class FlightTest extends TestCase {

    @Test
    public void testHoldsConstructedValues() {
        String carrier = "ABC";
        LocalTime departure = LocalTime.of(6, 30);

        Flight flight = new Flight(carrier, departure);

        assertEquals(carrier, flight.getCarrier());
        assertEquals(departure, flight.getDeparture());
    }

    @Test
    public void testIllegalArgumentExceptionWhenNullPassedForCarrier() {
        String carrier = null;
        LocalTime departure = LocalTime.of(6, 30);

        boolean thrown = false;

        try {
            new Flight(carrier, departure);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void testIllegalArgumentExceptionWhenNullPassedForDeparture() {
        String carrier = "ABC";
        LocalTime departure = null;

        boolean thrown = false;

        try {
            new Flight(carrier, departure);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }

        assertTrue(thrown);
    }
}