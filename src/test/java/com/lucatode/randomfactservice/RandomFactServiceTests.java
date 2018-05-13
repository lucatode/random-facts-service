package com.lucatode.randomfactservice;

import com.lucatode.randomfactservice.adapter.RandomFactConverter;
import com.lucatode.randomfactservice.adapter.RedditAdapter;
import com.lucatode.randomfactservice.entity.RandomFact;
import com.lucatode.randomfactservice.service.RandomFactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class RandomFactServiceTests {

    @MockBean
    private RedditAdapter redditAdapter;
    @MockBean
    private RandomFactConverter randomFactConverter;

    @Test
    public void testRedditAdapterCall(){
        when(redditAdapter.getRandomFact()).thenReturn(new RandomFact.Builder()
                .id("1")
                .title("First random fact")
                .text("Just my first random fact")
                .link("http://reddit.com/randomfact/1")
                .build());

        RandomFactService randomFactService = new RandomFactService(redditAdapter, randomFactConverter);
        randomFactService.getRandomFact();

        // Verify
        verify(redditAdapter, times(1)).getRandomFact();
    }

    @Test
    public void testConverterCall(){
        when(redditAdapter.getRandomFact()).thenReturn(new RandomFact.Builder()
                .id("1")
                .title("First random fact")
                .text("Just my first random fact")
                .link("http://reddit.com/randomfact/1")
                .build());
        when(randomFactConverter.toJsonString(any(RandomFact.class))).thenReturn("String by matcher");

        RandomFactService randomFactService = new RandomFactService(redditAdapter, randomFactConverter);
        randomFactService.getRandomFact();

        // Verify
        verify(randomFactConverter, times(1)).toJsonString(any(RandomFact.class));
    }





}
