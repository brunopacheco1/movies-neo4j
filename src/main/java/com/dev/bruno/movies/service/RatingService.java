package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.Movie;
import com.dev.bruno.movies.domain.Rating;
import com.dev.bruno.movies.domain.User;
import com.dev.bruno.movies.dto.RatingDTO;
import com.dev.bruno.movies.exceptions.EntityNotFound;
import com.dev.bruno.movies.repository.MovieRepository;
import com.dev.bruno.movies.repository.RatingRepository;
import com.dev.bruno.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private RatingRepository ratingRepository;
    private UserRepository userRepository;
    private MovieRepository movieRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository, UserRepository userRepository, MovieRepository movieRepository) {
        this.ratingRepository = ratingRepository;
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public void insert(RatingDTO ratingDTO) {
        Rating rating = new Rating();
        convertToEntity(rating, ratingDTO);
        ratingRepository.save(rating);
    }

    public void update(Long id, RatingDTO ratingDTO) {
        Rating rating = findOne(id);
        convertToEntity(rating, ratingDTO);
        ratingRepository.save(rating);
    }

    public void delete(Long id) {
        Rating rating = findOne(id);
        ratingRepository.delete(rating);
    }

    private Rating findOne(Long id) {
        return ratingRepository.findById(id).orElse(null);
    }

    private void convertToEntity(Rating entity, RatingDTO dto) {
        Movie movie = movieRepository.findById(dto.getMovieId()).orElseThrow(EntityNotFound::new);
        User user = userRepository.findById(dto.getUserId()).orElseThrow(EntityNotFound::new);

        entity.setComment(dto.getComment());
        entity.setStars(dto.getStars());
        entity.setMovie(movie);
        entity.setUser(user);
    }
}