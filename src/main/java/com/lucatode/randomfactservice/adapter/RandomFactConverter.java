package com.lucatode.randomfactservice.adapter;

import com.lucatode.randomfactservice.entity.RandomFact;

public class RandomFactConverter {
    public String toJsonString(RandomFact randomFact) {
        return "{\"id\":\"1\",\"title\":\"First random fact\", \"text\":\"Just my first random fact\", \"link\":\"http://reddit.com/randomfact/1\"}";
    }
}
