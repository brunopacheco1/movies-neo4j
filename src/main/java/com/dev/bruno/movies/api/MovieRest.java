package com.dev.bruno.movies.api;

import com.dev.bruno.movies.domain.Movie;
import com.dev.bruno.movies.dto.MovieDTO;
import com.dev.bruno.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class MovieRest {

    @Autowired
    private MovieService service;

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    public Movie get(@PathVariable(value="id") Long id) {
        return service.findOne(id);
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value="id") Long id, @RequestBody MovieDTO movie) {
        service.update(id, movie);
    }

    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    public Movie insert(@RequestBody MovieDTO movie) {
        return service.insert(movie);
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value="id") Long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public Iterable<Movie> list() {
        return service.findAll();
    }
}