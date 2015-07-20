package com.nakedgardener.application.configuration.converters;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.util.Date;

import static java.time.ZoneId.systemDefault;
import static java.util.Date.*;

public class LocalDateTimeToDateConverter implements Converter<LocalDateTime, Date> {

    @Override
    public Date convert(LocalDateTime source) {
        return source != null ?
            from(source.atZone(systemDefault()).toInstant()) :
            null;
    }
}
