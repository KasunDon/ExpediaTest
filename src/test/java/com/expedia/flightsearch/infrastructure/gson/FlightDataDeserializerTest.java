package com.expedia.flightsearch.infrastructure.gson;

import com.expedia.flightsearch.domain.entity.Flight;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.List;

public class FlightDataDeserializerTest {

    @Test
    public void testDeserializesJsonToFlight() {
        String source = "{\n"
                        + "    \"flights\": [{\n"
                        + "        \"flight\": \"Air Canada 8099\",\n"
                        + "        \"departure\": \"7:30AM\"\n"
                        + "    }]\n"
                        + "}";

        FlightDataDeserializer flightDataDeserializer = new FlightDataDeserializer();

        List<Flight> actualFlights = flightDataDeserializer.deserialize(source);

        Flight flight = actualFlights.get(0);

        Assert.assertEquals("Air Canada 8099", flight.getCarrier());
        Assert.assertEquals(LocalTime.of(7, 30), flight.getDeparture());

    }

    @Test
    public void testEmptyListWhenNoFlights() {
        String source = "{\n"
                        + "    \"flights\": []\n"
                        + "}";

        FlightDataDeserializer flightDataDeserializer = new FlightDataDeserializer();

        List<Flight> actualFlights = flightDataDeserializer.deserialize(source);

        Assert.assertEquals(0, actualFlights.size());
    }
}