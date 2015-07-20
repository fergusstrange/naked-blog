package com.nakedgardener.application.configuration.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.util.Date;

import static java.time.LocalDateTime.*;
import static java.time.ZoneId.systemDefault;

public class DateToLocalDateTimeConverter implements Converter<Date, LocalDateTime> {

    @Override
    public LocalDateTime convert(Date source) {
        return source != null ?
                ofInstant(source.toInstant(), systemDefault()) :
                null;
    }
}
