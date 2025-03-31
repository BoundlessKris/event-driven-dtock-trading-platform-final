package com.trading.userservice.service;

import com.trading.userservice.model.User;
import com.trading.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User register(User user) {
        return repository.save(user);
    }

    public Optional<User> getById(String id) {
        return repository.findById(id);
    }
}
