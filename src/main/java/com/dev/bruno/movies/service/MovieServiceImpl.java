package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.Movie;
import com.dev.bruno.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    public Movie save(Movie movie) {
        return repository.save(movie);
    }

    public void delete(Movie movie) {
        repository.delete(movie);
    }

    public Movie findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<Movie> findAll() {
        return repository.findAll();
    }
}