package com.lucatode.randomfactservice.service;

import com.lucatode.randomfactservice.adapter.RandomFactConverter;
import com.lucatode.randomfactservice.adapter.RedditAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomFactService {

    @Autowired
    private final RedditAdapter redditAdapter;
    @Autowired
    private final RandomFactConverter randomFactConverter;

    public RandomFactService(RedditAdapter redditAdapter, RandomFactConverter randomFactConverter) {
        this.redditAdapter = redditAdapter;
        this.randomFactConverter = randomFactConverter;
    }

    public String getRandomFact() {
        return this.randomFactConverter.toJsonString(this.redditAdapter.getRandomFact());
    }
}
