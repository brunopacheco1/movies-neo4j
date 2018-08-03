package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.Movie;

public interface MovieService {

    Movie save(Movie movie);

    void delete(Movie movie);

    Movie findOne(Long id);

    Iterable<Movie> findAll();
}