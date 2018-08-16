package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.Movie;
import com.dev.bruno.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public Movie insert(Movie movie) {
        return repository.save(movie);
    }

    public void update(Long id, Movie movie) {
        movie.setId(id);
        repository.save(movie);
    }

    public void delete(Long id) {
        Movie movie = findOne(id);
        repository.delete(movie);
    }

    public Movie findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<Movie> findAll() {
        return repository.findAll();
    }
}