package com.spaghettiteam.hotelapi.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WelcomeController {

    @CrossOrigin(origins = "https://hotelapi-backend.herokuapp.com")
    @GetMapping("/api")
    public String welcome() {
        return "Hello world!";
    }

    @CrossOrigin(origins = "https://hotelapi-backend.herokuapp.com")
    @GetMapping("/api/logged")
    public String welcomeForLogged() {
        return "Hello world for logged!";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @CrossOrigin(origins = "https://hotelapi-backend.herokuapp.com")
    @GetMapping("/api/admin")
    public String welcomeForAdmin() {
        return "Hello admin!";
    }
}