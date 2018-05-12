package com.lucatode.randomfactservice;

import com.lucatode.randomfactservice.adapter.RandomFactConverter;
import com.lucatode.randomfactservice.adapter.RedditAdapter;
import com.lucatode.randomfactservice.entity.RandomFact;
import com.lucatode.randomfactservice.service.RandomFactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class RandomFactServiceTests {

    @MockBean
    private RedditAdapter redditAdapter;
/*    @MockBean
    private RandomFactConverter randomFactConverter;*/

    @Test
    public void testRedditAdapterCall(){
        when(redditAdapter.getRandomFact()).thenReturn(RandomFact.builder());

        RandomFactService randomFactService = new RandomFactService(redditAdapter);
        randomFactService.getRandomFact();

        // Verify
        verify(redditAdapter, times(1)).getRandomFact();
    }



}
