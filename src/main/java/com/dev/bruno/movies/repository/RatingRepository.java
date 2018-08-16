package com.dev.bruno.movies.repository;

import com.dev.bruno.movies.domain.Rating;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RatingRepository extends Neo4jRepository<Rating, Long> {
}