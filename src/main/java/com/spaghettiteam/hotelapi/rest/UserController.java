package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.config.JWT.UserAuthenticationService;
import com.spaghettiteam.hotelapi.model.User;
import com.spaghettiteam.hotelapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserAuthenticationService authenticationService;
    @Autowired
    private UserService userService;

    @PostMapping("/api/user/add")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    String login(
            @RequestParam("username") final String username,
            @RequestParam("password") final String password) {
        System.out.println("logowanie");
        return authenticationService
                .login(username, password)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }

    @GetMapping("/register")
    String register(
            @RequestParam(required = false, name = "username") final String username,
            @RequestParam("password") final String password) {
        userService.saveUser(new User(username, password, "ad"));
        System.out.println("Zarejestrowano uzytkownika");
        return login(username, password);
    }

    @GetMapping("/users/current")
    User getCurrent(@AuthenticationPrincipal final User user) {
        return user;
    }


}
