package com.dev.bruno.movies.repository;

import com.dev.bruno.movies.domain.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {
}
