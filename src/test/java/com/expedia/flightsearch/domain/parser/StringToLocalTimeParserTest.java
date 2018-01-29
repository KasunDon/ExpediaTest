package com.expedia.flightsearch.domain.parser;

import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalTime;

public class StringToLocalTimeParserTest extends TestCase {

    StringToLocalTimeParser stringToLocalTimeParser = new StringToLocalTimeParser();

    @Test
    public void testConvertsStringTimeToLocalTime() {
        String time = "6:00AM";
        LocalTime expect = LocalTime.of(6, 0);

        assertEquals(expect, stringToLocalTimeParser.parse(time));

        String time2 = "6:00AM";
        LocalTime expect2 = LocalTime.of(6, 0);

        assertEquals(expect2, stringToLocalTimeParser.parse(time2));
    }

}