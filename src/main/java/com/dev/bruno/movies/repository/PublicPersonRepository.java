package com.dev.bruno.movies.repository;

import com.dev.bruno.movies.domain.PublicPerson;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PublicPersonRepository extends Neo4jRepository<PublicPerson, Long> {

}