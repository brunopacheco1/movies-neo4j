package com.dev.bruno.movies;

import com.dev.bruno.movies.domain.Movie;
import com.dev.bruno.movies.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MovieServiceTest {

    @Autowired
    private MovieService service;

    @Test
    public void testSave() {
        Movie movie = null;

        assertNull(movie);
    }
}