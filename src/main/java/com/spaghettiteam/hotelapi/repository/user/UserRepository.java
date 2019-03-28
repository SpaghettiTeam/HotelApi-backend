package com.spaghettiteam.hotelapi.repository.user;

import com.spaghettiteam.hotelapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    Optional<User> findById(long id);

    User save(User user);

    Optional<User> findByUsername(String username);
}
