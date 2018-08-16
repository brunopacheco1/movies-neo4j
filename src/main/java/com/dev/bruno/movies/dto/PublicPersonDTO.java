package com.dev.bruno.movies.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PublicPersonDTO {

    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    private LocalDateTime startedCarreeAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartedCarreeAt() {
        return startedCarreeAt;
    }

    public void setStartedCarreeAt(LocalDateTime startedCarreeAt) {
        this.startedCarreeAt = startedCarreeAt;
    }
}
