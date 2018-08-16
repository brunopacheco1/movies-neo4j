package com.dev.bruno.movies.repository;

import com.dev.bruno.movies.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, Long> {

}