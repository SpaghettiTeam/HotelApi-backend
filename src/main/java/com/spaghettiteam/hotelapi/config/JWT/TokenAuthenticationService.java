package com.spaghettiteam.hotelapi.config.JWT;

import com.google.common.collect.ImmutableMap;
import com.spaghettiteam.hotelapi.model.User;
import com.spaghettiteam.hotelapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public final class TokenAuthenticationService implements UserAuthenticationService{

    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;

    @Override
    public Optional<String> login(String username, String password) {
        return userService
                .findOptionalByUsername(username)
                .filter(user -> Objects.equals(password, user.getPassword()))
                .map(user -> tokenService.expiring(ImmutableMap.of("username", username)));
    }

    @Override
    public Optional<User> findByToken(String token) {
        return Optional
                .of(tokenService.verify(token))
                .map(map -> map.get("username"))
                .flatMap(userService::findOptionalByUsername);
    }

    @Override
    public void logout(User user) {

    }
}
