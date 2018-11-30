package com.spaghettiteam.hotelapi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/api")
    public String welcome() {
        return "Hello world!";
    }

}