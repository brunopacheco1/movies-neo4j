package com.dev.bruno.movies.api;

import com.dev.bruno.movies.dto.RoleDTO;
import com.dev.bruno.movies.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RoleRest {

    @Autowired
    private RoleService service;

    @RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value="id") Long id, @RequestBody RoleDTO roleDTO) {
        service.update(id, roleDTO);
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public void insert(@RequestBody RoleDTO roleDTO) {
        service.insert(roleDTO);
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value="id") Long id) {
        service.delete(id);
    }
}