package com.lucatode.randomfactservice.controllers;

import com.lucatode.randomfactservice.service.RandomFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RandomFactController {

    @Autowired
    private final RandomFactService randomFactService;

    public RandomFactController(RandomFactService randomFactService) {
        this.randomFactService = randomFactService;
    }

    @RequestMapping(value = "/randomFact", method = RequestMethod.GET)
    public @ResponseBody String getRandomFact(){
        return randomFactService.getRandomFact();
    }

}
