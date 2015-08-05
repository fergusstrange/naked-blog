package com.nakedgardener.web.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class HealthOKController {

    @ResponseBody
    @RequestMapping(value = "/", method = GET, produces = APPLICATION_JSON_VALUE)
    public OKStatus healthCheck() {
        return new OKStatus();
    }

    private class OKStatus {
        @JsonProperty
        private final String status = "OK";
    }
}
