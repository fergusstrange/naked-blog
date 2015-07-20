package com.nakedgardener.application.configuration.converters;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LocalDateTimeToDateConverterTest {

    private final LocalDateTimeToDateConverter localDateTimeToDateConverter = new LocalDateTimeToDateConverter();

    @Test
    public void shouldConvertLocalDateTimeToDate() throws Exception {
        Date convertedLocalDateTime = localDateTimeToDateConverter.convert(LocalDateTime.of(2014, 12, 12, 3, 3, 2));

        assertEquals(new Date(1418353382000L), convertedLocalDateTime);
    }

    @Test
    public void shouldReturnNullIfPassedNull() throws Exception {
        Date convertedLocalDateTime = localDateTimeToDateConverter.convert(null);

        assertNull(convertedLocalDateTime);
    }
}