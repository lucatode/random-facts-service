package com.lucatode.randomfactservice;

import com.lucatode.randomfactservice.controllers.RandomFact;
import com.lucatode.randomfactservice.controllers.RandomFactService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.stream.DoubleStream;

import static org.mockito.Mockito.when;

public class RandomFactControllerTests {

;
    private MockMvc mockMvc;

    @Autowired
    private RandomFactService controllerMock;

    @Test
    void theControllerHasToReturnAJson(){
        // Mock the service
        when(controllerMock.getRandomFact()).thenReturn(RandomFact.builder().toJsonString());

    }

}
