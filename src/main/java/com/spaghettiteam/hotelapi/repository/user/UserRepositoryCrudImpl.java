package com.spaghettiteam.hotelapi.repository.user;

import com.spaghettiteam.hotelapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryCrudImpl implements UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public User save(User user) {
        return userCrudRepository.save(user);
    }

    @Override
    public Optional<User> findById(long id) {
        return userCrudRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userCrudRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userCrudRepository.findByEmail(email);
    }
}
