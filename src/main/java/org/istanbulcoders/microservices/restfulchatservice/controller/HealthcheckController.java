package org.istanbulcoders.microservices.restfulchatservice.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {
    @RequestMapping(value = "/*", method = RequestMethod.GET)
    HttpEntity<Object> index() {
        return new ResponseEntity<Object>("ok", HttpStatus.OK);
    }
}