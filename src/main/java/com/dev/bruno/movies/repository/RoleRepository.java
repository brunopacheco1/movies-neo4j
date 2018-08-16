package com.dev.bruno.movies.repository;

import com.dev.bruno.movies.domain.Role;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RoleRepository extends Neo4jRepository<Role, Long> {
}