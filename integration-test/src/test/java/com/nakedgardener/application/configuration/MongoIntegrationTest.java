package com.nakedgardener.application.configuration;

import com.nakedgardener.test.mongodb.MongoDBTestExecutionListener;
import org.springframework.boot.test.IntegrationTestPropertiesListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@TestExecutionListeners(listeners = {
    IntegrationTestPropertiesListener.class,
    MongoDBTestExecutionListener.class,
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class
})
public @interface MongoIntegrationTest {
}
