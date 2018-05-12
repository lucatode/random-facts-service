package com.lucatode.randomfactservice;

import com.lucatode.randomfactservice.controllers.RandomFactController;
import com.lucatode.randomfactservice.service.RandomFactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RandomFactController.class)
public class RandomFactControllerTests {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private RandomFactService serviceMock;


    @Test
    public void controllerCallsService() throws Exception {
        // Mock the service
        when(serviceMock.getRandomFact()).thenReturn("");

        // HTTP Call
        mvc.perform(get("/randomFact")).andExpect(status().isOk());

        // Verify
        verify(serviceMock, times(1)).getRandomFact();
    }

    @Test
    public void theCallReturnAJson() throws Exception {
        // Mock the service
        String expected = "{\"id\":\"1\",\"title\":\"First random fact\", \"text\":\"Just my first random facts\", \"link\":\"http://reddit.com/randomfact/1\"}";
        when(serviceMock.getRandomFact()).thenReturn(expected);

        // HTTP Call
        MvcResult res = mvc.perform(get("/randomFact")).andExpect(status().isOk()).andReturn();

        // Verify
        String content = res.getResponse().getContentAsString();
        assertEquals(expected, content);
    }

    @Test
    public void containsAllJsonFields() throws Exception {
        // Mock the service
        String expected = "{\"id\":\"1\",\"title\":\"First random fact\", \"text\":\"Just my first random facts\", \"link\":\"http://reddit.com/randomfact/1\"}";
        when(serviceMock.getRandomFact()).thenReturn(expected);

        // HTTP Call
        MvcResult res = mvc.perform(get("/randomFact")).andReturn();

        // Verify
        String content = res.getResponse().getContentAsString();
        assertTrue(content.contains("\"id\":"));
        assertTrue(content.contains("\"title\":"));
        assertTrue(content.contains("\"text\":"));
        assertTrue(content.contains("\"link\":"));
    }

}
