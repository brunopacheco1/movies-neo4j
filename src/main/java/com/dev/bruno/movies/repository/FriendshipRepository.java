package com.dev.bruno.movies.repository;

import com.dev.bruno.movies.domain.Friendship;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FriendshipRepository extends Neo4jRepository<Friendship, Long> {
}