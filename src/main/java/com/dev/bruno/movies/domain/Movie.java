package com.dev.bruno.movies.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;
import java.util.Set;

@NodeEntity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Relationship(type="DIRECTED", direction = Relationship.INCOMING)
    private PublicPerson director;

    @Relationship(type="ACTS_IN", direction = Relationship.INCOMING)
    private Set<Role> actors;

    @Relationship(type = "RATED", direction = Relationship.INCOMING)
    private List<Rating> ratings;

    private Integer releasedYear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public PublicPerson getDirector() {
        return director;
    }

    public void setDirector(PublicPerson director) {
        this.director = director;
    }

    public Set<Role> getActors() {
        return actors;
    }

    public void setActors(Set<Role> actors) {
        this.actors = actors;
    }

    public Integer getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(Integer releasedYear) {
        this.releasedYear = releasedYear;
    }
}