package com.spaghettiteam.hotelapi.service;

import com.spaghettiteam.hotelapi.exception.UserAlreadyExistException;
import com.spaghettiteam.hotelapi.exception.UserNotFoundException;
import com.spaghettiteam.hotelapi.model.User;
import com.spaghettiteam.hotelapi.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public Optional<User> findOptionalByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(User user) {
        if (!findOptionalByUsername(user.getUsername()).isPresent()
            || !findByEmail(user.getEmail()).isPresent())
            return userRepository.save(user);
        throw new UserAlreadyExistException();
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
