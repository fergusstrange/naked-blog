package com.nakedgardener.application.configuration.converters;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DateToLocalDateTimeConverterTest {

    private DateToLocalDateTimeConverter dateToLocalDateTimeConverter = new DateToLocalDateTimeConverter();

    @Test
    public void shouldConvertDateToLocalDateTime() throws Exception {
        LocalDateTime localDateTime = dateToLocalDateTimeConverter.convert(new Date(1418353382000L));

        assertEquals(LocalDateTime.of(2014, 12, 12, 3, 3, 2), localDateTime);
    }

    @Test
    public void shouldReturnNullWhenPassedNull() throws Exception {
        LocalDateTime localDateTime = dateToLocalDateTimeConverter.convert(null);

        assertNull(localDateTime);
    }
}