package com.expedia.flightsearch.domain.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StringToLocalTimeParser implements TimeParser {

    private final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("hh:mmaa");

    public LocalTime parse(
        String source
    ) {
        try {

            Date date = TIME_FORMAT.parse(source);

            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(date);

            return LocalTime.of(
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE)
            );
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
