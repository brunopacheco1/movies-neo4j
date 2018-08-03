package com.dev.bruno.movies.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "ACTS_IN")
public class Role {

    @StartNode
    private PublicPerson actor;

    @EndNode
    private Movie movie;

    private String name;

    public PublicPerson getActor() {
        return actor;
    }

    public void setActor(PublicPerson actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}