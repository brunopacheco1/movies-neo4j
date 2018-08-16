package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.PublicPerson;
import com.dev.bruno.movies.repository.PublicPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PublicPersonService {

    @Autowired
    private PublicPersonRepository repository;

    public PublicPerson insert(PublicPerson publicPerson) {
        return repository.save(publicPerson);
    }

    public void update(Long id, PublicPerson publicPerson) {
        publicPerson.setId(id);
        repository.save(publicPerson);
    }

    public void delete(Long id) {
        PublicPerson publicPerson = findOne(id);
        repository.delete(publicPerson);
    }

    public PublicPerson findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<PublicPerson> findAll() {
        return repository.findAll();
    }
}