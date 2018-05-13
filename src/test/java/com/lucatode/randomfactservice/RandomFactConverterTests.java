package com.lucatode.randomfactservice;

import com.lucatode.randomfactservice.adapter.RandomFactConverter;
import com.lucatode.randomfactservice.entity.RandomFact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class RandomFactConverterTests {

    @Test
    public void testRandomFactToJson(){
        // Setup
        RandomFactConverter randomFactConverter = new RandomFactConverter();
        RandomFact randomFact = new RandomFact.Builder()
                .id("1")
                .title("First random fact")
                .text("Just my first random fact")
                .link("http://reddit.com/randomfact/1")
                .build();

        // Execute
        String json = randomFactConverter.toJsonString(randomFact);

        // Verify
        String expected = "{\"id\":\"1\",\"title\":\"First random fact\", \"text\":\"Just my first random fact\", \"link\":\"http://reddit.com/randomfact/1\"}";
        assertEquals(expected, json);
    }

}
