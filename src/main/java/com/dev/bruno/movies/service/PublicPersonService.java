package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.Movie;
import com.dev.bruno.movies.domain.PublicPerson;
import com.dev.bruno.movies.dto.PublicPersonDTO;
import com.dev.bruno.movies.exceptions.EntityNotFound;
import com.dev.bruno.movies.repository.MovieRepository;
import com.dev.bruno.movies.repository.PublicPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicPersonService {

    private PublicPersonRepository publicPersonRepository;
    private MovieRepository movieRepository;

    @Autowired
    public PublicPersonService(PublicPersonRepository publicPersonRepository, MovieRepository movieRepository) {
        this.publicPersonRepository = publicPersonRepository;
        this.movieRepository = movieRepository;
    }

    public PublicPerson insert(PublicPersonDTO publicPersonDTO) {
        PublicPerson publicPerson = new PublicPerson();
        convertToEntity(publicPerson, publicPersonDTO);
        return publicPersonRepository.save(publicPerson);
    }

    public void update(Long id, PublicPersonDTO publicPersonDTO) {
        PublicPerson publicPerson = findOne(id);
        convertToEntity(publicPerson, publicPersonDTO);
        publicPersonRepository.save(publicPerson);
    }

    public void delete(Long id) {
        PublicPerson publicPerson = findOne(id);
        publicPersonRepository.delete(publicPerson);
    }

    public PublicPerson findOne(Long id) {
        return publicPersonRepository.findById(id).orElse(null);
    }

    public Iterable<PublicPerson> findAll() {
        return publicPersonRepository.findAll();
    }

    private void convertToEntity(PublicPerson entity, PublicPersonDTO dto) {
        entity.setStartedCarreeAt(dto.getStartedCarreeAt());
        entity.setName(dto.getName());
    }

    public void directed(Long id, Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(EntityNotFound::new);
        PublicPerson director = publicPersonRepository.findById(id).orElseThrow(EntityNotFound::new);
        movie.setDirector(director);
        movieRepository.save(movie);
    }
}