package com.spaghettiteam.hotelapi.rest;

import com.spaghettiteam.hotelapi.model.User;
import com.spaghettiteam.hotelapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user/add")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
