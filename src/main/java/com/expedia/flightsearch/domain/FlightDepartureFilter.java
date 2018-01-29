package com.expedia.flightsearch.domain;

import com.expedia.flightsearch.domain.entity.Flight;

import java.time.LocalTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightDepartureFilter {

    private List<Flight> flights;

    public void setFlights(
        List<Flight> flights
    ) {
        if (flights == null) {
            throw new IllegalArgumentException("flights cannot be null.");
        }

        this.flights = flights;
    }

    public List<Flight> filter(
        LocalTime searchTime
    ) {

        if (flights == null) {
            throw new IllegalStateException("flights not set.");
        }

        LocalTime minusFiveHours = searchTime.minusHours(5);
        LocalTime plusFiveHours = searchTime.plusHours(5);

        return flights
            .stream()
            .filter(flight -> flight.getDeparture().isBefore(plusFiveHours))
            .filter(flight -> flight.getDeparture().isAfter(minusFiveHours))
            .collect(toList());
    }
}
