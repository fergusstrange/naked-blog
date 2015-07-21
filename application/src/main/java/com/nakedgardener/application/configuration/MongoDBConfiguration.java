package com.nakedgardener.application.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.nakedgardener.application.configuration.converters.DateToLocalDateTimeConverter;
import com.nakedgardener.application.configuration.converters.LocalDateTimeToDateConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static java.util.Arrays.asList;

@Configuration
@EnableMongoRepositories(basePackages = "com.nakedgardener")
public class MongoDBConfiguration extends AbstractMongoConfiguration {

    @Value("${mongo.host:localhost}")
    private String mongoHost;

    @Value("${mongo.host.port:27017}")
    private int mongoHostPort;

    @Value("${mongo.databse.name:naked-blog}")
    private String mongoDatabaseName;

    @Override
    protected String getDatabaseName() {
        return mongoDatabaseName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoHost, mongoHostPort);
    }

    @Override
    public CustomConversions customConversions() {
        return new CustomConversions(asList(
                new LocalDateTimeToDateConverter(),
                new DateToLocalDateTimeConverter()
        ));
    }
}
