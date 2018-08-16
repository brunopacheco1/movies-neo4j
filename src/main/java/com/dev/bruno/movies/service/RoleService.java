package com.dev.bruno.movies.service;

import com.dev.bruno.movies.domain.Movie;
import com.dev.bruno.movies.domain.PublicPerson;
import com.dev.bruno.movies.domain.Role;
import com.dev.bruno.movies.dto.RoleDTO;
import com.dev.bruno.movies.exceptions.EntityNotFound;
import com.dev.bruno.movies.repository.MovieRepository;
import com.dev.bruno.movies.repository.PublicPersonRepository;
import com.dev.bruno.movies.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;
    private PublicPersonRepository publicPersonRepository;
    private MovieRepository movieRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository, PublicPersonRepository publicPersonRepository, MovieRepository movieRepository) {
        this.roleRepository = roleRepository;
        this.movieRepository = movieRepository;
        this.publicPersonRepository = publicPersonRepository;
    }

    public void insert(RoleDTO roleDTO) {
        Role role = new Role();
        convertToEntity(role, roleDTO);
        roleRepository.save(role);
    }

    public void update(Long id, RoleDTO roleDTO) {
        Role role = findOne(id);
        convertToEntity(role, roleDTO);
        roleRepository.save(role);
    }

    public void delete(Long id) {
        Role role = findOne(id);
        roleRepository.delete(role);
    }

    private Role findOne(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    private void convertToEntity(Role entity, RoleDTO dto) {
        Movie movie = movieRepository.findById(dto.getMovieId()).orElseThrow(EntityNotFound::new);
        PublicPerson actor = publicPersonRepository.findById(dto.getActorId()).orElseThrow(EntityNotFound::new);

        entity.setName(dto.getName());
        entity.setMovie(movie);
        entity.setActor(actor);
    }
}