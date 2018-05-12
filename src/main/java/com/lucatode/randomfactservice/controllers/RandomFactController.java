package com.lucatode.randomfactservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RandomFactController {

    private RandomFactService randomFactService;

    @RequestMapping(value = "/RandomFact", method = RequestMethod.GET)
    public String getRandomFact(){
        return randomFactService.getRandomFact();
    }

}
