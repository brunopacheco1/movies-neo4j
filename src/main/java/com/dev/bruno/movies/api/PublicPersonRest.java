package com.dev.bruno.movies.api;

import com.dev.bruno.movies.domain.PublicPerson;
import com.dev.bruno.movies.domain.PublicPerson;
import com.dev.bruno.movies.dto.PublicPersonDTO;
import com.dev.bruno.movies.service.PublicPersonService;
import com.dev.bruno.movies.service.PublicPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PublicPersonRest {

    @Autowired
    private PublicPersonService service;

    @RequestMapping(value = "/public-person/{id}", method = RequestMethod.GET)
    public PublicPerson get(@PathVariable(value="id") Long id) {
        return service.findOne(id);
    }

    @RequestMapping(value = "/public-person/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value="id") Long id, @RequestBody PublicPersonDTO publicPersonDTO) {
        service.update(id, publicPersonDTO);
    }

    @RequestMapping(value = "/public-person/{id}/directed/{movieId}", method = RequestMethod.PUT)
    public void update(@PathVariable(value="id") Long id, @PathVariable(value="movieId") Long movieId) {
        service.directed(id, movieId);
    }

    @RequestMapping(value = "/public-person", method = RequestMethod.POST)
    public PublicPerson insert(@RequestBody PublicPersonDTO publicPersonDTO) {
        return service.insert(publicPersonDTO);
    }

    @RequestMapping(value = "/public-person/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value="id") Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/public-person", method = RequestMethod.GET)
    public Iterable<PublicPerson> list() {
        return service.findAll();
    }
}