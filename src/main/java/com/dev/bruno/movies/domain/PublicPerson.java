package com.dev.bruno.movies.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDateTime;
import java.util.Set;

@NodeEntity
public class PublicPerson extends Person {

    private LocalDateTime startedCarreeAt;

    @Relationship(type = "ACTS_IN")
    private Set<Role> roles;

    @Relationship(type="DIRECTED")
    private Set<Movie> directedMovies;

    public LocalDateTime getStartedCarreeAt() {
        return startedCarreeAt;
    }

    public void setStartedCarreeAt(LocalDateTime startedCareeAt) {
        this.startedCarreeAt = startedCareeAt;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Movie> getDirectedMovies() {
        return directedMovies;
    }

    public void setDirectedMovies(Set<Movie> directedMovies) {
        this.directedMovies = directedMovies;
    }
}