package com.nakedgardener.application.configuration;

import com.mongodb.MongoClient;
import com.nakedgardener.application.configuration.converters.LocalDateTimeToDateConverter;
import com.nakedgardener.application.configuration.converters.DateToLocalDateTimeConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static java.util.Arrays.asList;

@Configuration
@EnableMongoRepositories(basePackages = "com.nakedgardener")
public class MongoDBConfiguration {

    @Value("${mongo.host:localhost}")
    private String mongoHost;

    @Value("${mongo.host.port:27017}")
    private int mongoHostPort;

    @Value("${mongo.databse.name:naked-blog}")
    private String mongoDatabaseName;

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public SimpleMongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(new MongoClient(mongoHost, mongoHostPort), mongoDatabaseName);
    }

    @Bean
    public CustomConversions customConversions() {
        return new CustomConversions(asList(
                new LocalDateTimeToDateConverter(),
                new DateToLocalDateTimeConverter()
        ));
    }
}
