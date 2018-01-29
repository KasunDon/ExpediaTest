package com.expedia.flightsearch.domain.entity;

import java.time.LocalTime;

public class Flight {

    private final String carrier;
    private final LocalTime departure;

    public Flight(
        String carrier,
        LocalTime departure
    ) {
        if (carrier == null) {
            throw new IllegalArgumentException("carrier cannot be null.");
        }

        if (departure == null) {
            throw new IllegalArgumentException("departure cannot be null.");
        }

        this.carrier = carrier;
        this.departure = departure;
    }

    public String getCarrier() {
        return carrier;
    }

    public LocalTime getDeparture() {
        return departure;
    }
}
