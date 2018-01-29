package com.expedia.flightsearch;

import com.expedia.flightsearch.domain.FlightDepartureFilter;
import com.expedia.flightsearch.domain.FlightFinder;
import com.expedia.flightsearch.domain.entity.Flight;
import com.expedia.flightsearch.domain.parser.StringToLocalTimeParser;
import com.expedia.flightsearch.domain.parser.TimeParser;
import com.expedia.flightsearch.domain.validator.DepartureTimeParameterValidator;
import com.expedia.flightsearch.domain.validator.InputParameterValidator;
import com.expedia.flightsearch.infrastructure.gson.FlightDataDeserializer;
import com.expedia.flightsearch.library.serialization.Deserializer;
import com.google.gson.Gson;
import spark.resource.ClassPathResource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.port;

public class FlightSearchApp {

    public static void main(String[] args) throws URISyntaxException, IOException {

        /**
         * Reading flight data from classpath
         */
        String flightsData =
            new String(Files.readAllBytes(
                Paths.get(new ClassPathResource("/data/flights.json").getURI())));

        /**
         * Declared all dependencies without Dependency Injection setup/framework
         */
        Deserializer<String, List<Flight>> flightDataDeserializer = new FlightDataDeserializer();
        FlightDepartureFilter flightDepartureFilter = new FlightDepartureFilter();
        InputParameterValidator<String> inputParameterValidator = new DepartureTimeParameterValidator();
        TimeParser timeParser = new StringToLocalTimeParser();
        FlightFinder flightFinder = new FlightFinder(inputParameterValidator, timeParser, flightDepartureFilter);

        List<Flight> flights = flightDataDeserializer.deserialize(flightsData);
        flightDepartureFilter.setFlights(flights);


        /**
         * SparkJava to host REST interface
         */
        port(8080);

        get(
            "/flight-search/:departureTime",
            (request, response) -> flightFinder.find(request.params("departureTime")),
            model -> new Gson().toJson(model));

        after((request, response) -> {
            response.type("application/json");
        });

    }
}
