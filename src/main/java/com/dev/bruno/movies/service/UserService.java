package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.User;
import com.dev.bruno.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository repository;

    public User insert(User user) {
        return repository.save(user);
    }

    public void update(Long id, User user) {
        user.setId(id);
        repository.save(user);
    }

    public void delete(Long id) {
        User user = findOne(id);
        repository.delete(user);
    }

    public User findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<User> findAll() {
        return repository.findAll();
    }
}