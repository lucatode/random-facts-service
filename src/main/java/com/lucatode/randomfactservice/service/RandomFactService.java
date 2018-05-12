package com.lucatode.randomfactservice.service;

import com.lucatode.randomfactservice.adapter.RedditAdapter;
import com.lucatode.randomfactservice.entity.RandomFact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomFactService {

    @Autowired
    private final RedditAdapter redditAdapter;

    public RandomFactService(RedditAdapter redditAdapter) {
        this.redditAdapter = redditAdapter;
    }

    public String getRandomFact() {
        // "{\"id\":\"1\",\"title\":\"First random fact\", \"text\":\"Just my first random facts\", \"link\":\"http://reddit.com/randomfact/1\"}";
        return this.redditAdapter.getRandomFact().toJsonString();
    }
}
