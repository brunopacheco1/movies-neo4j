package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.Movie;
import com.dev.bruno.movies.dto.MovieDTO;
import com.dev.bruno.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Movie insert(MovieDTO movieDTO) {
        Movie movie = new Movie();
        convertToEntity(movie, movieDTO);
        return repository.save(movie);
    }

    public void update(Long id, MovieDTO movieDTO) {
        Movie movie = findOne(id);
        convertToEntity(movie, movieDTO);
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

    private void convertToEntity(Movie entity, MovieDTO dto) {
        entity.setReleasedYear(dto.getReleasedYear());
        entity.setTitle(dto.getTitle());
    }
}