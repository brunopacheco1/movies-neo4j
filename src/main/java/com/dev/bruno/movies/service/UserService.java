package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.User;
import com.dev.bruno.movies.dto.UserDTO;
import com.dev.bruno.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User insert(UserDTO userDTO) {
        User user = new User();
        convertToEntity(user, userDTO);
        return repository.save(user);
    }

    public void update(Long id, UserDTO userDTO) {
        User user = findOne(id);
        convertToEntity(user, userDTO);
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

    private void convertToEntity(User entity, UserDTO dto) {
        entity.setLogin(dto.getLogin());
        entity.setPassword(dto.getPassword());
        entity.setName(dto.getName());
    }
}