package com.expedia.flightsearch.domain.parser;

import java.time.LocalTime;

public interface TimeParser {

    LocalTime parse(String source);
}