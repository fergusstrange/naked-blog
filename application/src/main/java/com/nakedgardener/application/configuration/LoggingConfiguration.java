package com.nakedgardener.application.configuration;

import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.slf4j.LoggerFactory.getLogger;

@Configuration
public class LoggingConfiguration {

    @Bean
    public Logger applicationErrorLog() {
        return getLogger("com.nakedgardener.logging.error");
    }
}
