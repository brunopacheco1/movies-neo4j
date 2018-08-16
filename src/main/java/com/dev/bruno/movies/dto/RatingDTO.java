package com.dev.bruno.movies.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RatingDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Long movieId;

    @NotNull
    private Integer stars;

    @NotEmpty
    private String comment;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
