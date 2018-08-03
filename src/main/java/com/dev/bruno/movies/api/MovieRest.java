package com.dev.bruno.movies.api;

import com.dev.bruno.movies.domain.Movie;
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

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public Iterable<Movie> list() {
        return service.findAll();
    }
}