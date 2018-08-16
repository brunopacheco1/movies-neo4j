package com.dev.bruno.movies.domain;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "RATED")
public class Rating {

    @Id
    @GeneratedValue
    private Long relationshipId;

    @StartNode
    private User user;

    @EndNode
    private Movie movie;

    private int stars;

    private String comment;

    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}