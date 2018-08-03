package com.dev.bruno.movies.repository;

import com.dev.bruno.movies.domain.Movie;
import com.dev.bruno.movies.domain.Person;
import com.dev.bruno.movies.domain.Rating;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    // derived finder
    Movie findByTitle(String title);

    @Query("MATCH (m:Movie)<-[rating:RATED]-(user) WHERE id(movie)={movie} return rating")
    List<Rating> getRatings(@Param("movie") Movie movie);

    // Co-Actors
    Set<Person> findByActorsMoviesActorName(String name);

    @Query("MATCH (movie:Movie)-[:HAS_GENRE]->(genre)<-[:HAS_GENRE]-(similar) WHERE id(movie) = {0} RETURN similar")
    List<Movie> findSimilarMovies(Movie movie);
}
