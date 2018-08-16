package com.dev.bruno.movies.api;

import com.dev.bruno.movies.domain.User;
import com.dev.bruno.movies.dto.UserDTO;
import com.dev.bruno.movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserRest {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User get(@PathVariable(value="id") Long id) {
        return service.findOne(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value="id") Long id, @RequestBody UserDTO userDTO) {
        service.update(id, userDTO);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User insert(@RequestBody UserDTO userDTO) {
        return service.insert(userDTO);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value="id") Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Iterable<User> list() {
        return service.findAll();
    }
}