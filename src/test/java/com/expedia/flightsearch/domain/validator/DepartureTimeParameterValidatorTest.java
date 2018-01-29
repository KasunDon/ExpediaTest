package com.expedia.flightsearch.domain.validator;

import junit.framework.TestCase;
import org.junit.Test;

public class DepartureTimeParameterValidatorTest extends TestCase {

    DepartureTimeParameterValidator departureTimeParameterValidator = new DepartureTimeParameterValidator();

    @Test
    public void testThrowAnExceptionWhenDepartureTimeIsNull() {

        String departureTime = null;

        boolean thrown = false;

        try {
            departureTimeParameterValidator.validate(departureTime);
        } catch (IllegalStateException e) {
            thrown = true;
        }

        assertEquals(true, thrown);
    }

    @Test
    public void testThrowAnExceptionWhenDepartureTimeIsEmpty() {

        String departureTime = "";

        boolean thrown = false;

        try {
            departureTimeParameterValidator.validate(departureTime);
        } catch (IllegalStateException e) {
            thrown = true;
        }

        assertEquals(true, thrown);
    }
}