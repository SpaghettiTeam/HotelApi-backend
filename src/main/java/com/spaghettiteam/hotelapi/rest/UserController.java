package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.config.JWT.UserAuthenticationService;
import com.spaghettiteam.hotelapi.dto.UserToLogin;
import com.spaghettiteam.hotelapi.dto.UserToRegister;
import com.spaghettiteam.hotelapi.exception.InvalidUserCredentials;
import com.spaghettiteam.hotelapi.model.User;
import com.spaghettiteam.hotelapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserAuthenticationService authenticationService;
    @Autowired
    private UserService userService;

    @PostMapping("/api/user/add")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserToLogin user) {
        return authenticationService
                .login(user.getUsername(), user.getPassword())
                .orElseThrow(InvalidUserCredentials::new);
    }

    @PostMapping("/register")
    public String register(@RequestBody UserToRegister user) {
        userService.saveUser(new User(user.getUsername(), user.getPassword(), user.getEmail()));
        return login(new UserToLogin(user.getUsername(), user.getPassword()));
    }

    @GetMapping("/users/current")
    public User getCurrent(@AuthenticationPrincipal final User user) {
        return user;
    }
}
