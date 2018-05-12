package com.lucatode.randomfactservice.service;

import org.springframework.stereotype.Component;

@Component
public class RandomFactService {
    public String getRandomFact() {
        return "{\"id\":\"1\",\"title\":\"First random fact\", \"text\":\"Just my first random facts\", \"link\":\"http://reddit.com/randomfact/1\"}";

    }
}
