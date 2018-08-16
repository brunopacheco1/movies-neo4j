package com.dev.bruno.movies.api;

import com.dev.bruno.movies.dto.FriendshipDTO;
import com.dev.bruno.movies.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class FriendshipRest {

    @Autowired
    private FriendshipService service;

    @RequestMapping(value = "/friendship/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value="id") Long id, @RequestBody FriendshipDTO friendshipDTO) {
        service.update(id, friendshipDTO);
    }

    @RequestMapping(value = "/friendship", method = RequestMethod.POST)
    public void insert(@RequestBody FriendshipDTO friendshipDTO) {
        service.insert(friendshipDTO);
    }

    @RequestMapping(value = "/friendship/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value="id") Long id) {
        service.delete(id);
    }
}