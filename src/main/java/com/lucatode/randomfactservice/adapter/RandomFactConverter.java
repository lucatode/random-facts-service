package com.lucatode.randomfactservice.adapter;

import com.lucatode.randomfactservice.entity.RandomFact;
import org.springframework.stereotype.Component;

@Component
public class RandomFactConverter {

    public String toJsonString(RandomFact randomFact) {

        //TODO: fix using real converter
        return "{\"id\":\"1\",\"title\":\"First random fact\", \"text\":\"Just my first random fact\", \"link\":\"http://reddit.com/randomfact/1\"}";
    }
}
