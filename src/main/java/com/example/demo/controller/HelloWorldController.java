package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldController {
    
    private static Logger log = LoggerFactory.getLogger(HelloWorldController.class);
    
    private final RestTemplate restTemplate;
    
    HelloWorldController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
    
    @RequestMapping("/")
    String hello() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-forwarded-for", "first");
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8082/first",
                HttpMethod.GET,
                request,
                String.class
            );
        String result = response.getBody();
        log.info("Reply = " + result);
        return "Hello World, Spring Boot!" + result;
    }
    
    @RequestMapping("/first") 
    String helloWorld() {
        return "Hello World, from first service";
    }

}
