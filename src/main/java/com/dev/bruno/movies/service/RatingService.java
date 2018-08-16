package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.Rating;
import com.dev.bruno.movies.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RatingService {

    @Autowired
    private RatingRepository repository;

    public Rating insert(Rating rating) {
        return repository.save(rating);
    }

    public void delete(Long id) {
        Rating rating = findOne(id);
        repository.delete(rating);
    }

    public Rating findOne(Long id) {
        return repository.findById(id).orElse(null);
    }
}