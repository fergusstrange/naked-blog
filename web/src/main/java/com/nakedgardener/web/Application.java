package com.nakedgardener.web;

import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nakedgardener")
public class Application {
    public static void main(String... args) {
        new SpringApplicationBuilder()
                .sources(Application.class)
                .listeners(new ApplicationPidFileWriter())
                .build()
                .run(args);
    }
}

