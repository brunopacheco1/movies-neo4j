package com.dev.bruno.movies.api;

import com.dev.bruno.movies.dto.RatingDTO;
import com.dev.bruno.movies.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RatingRest {

    @Autowired
    private RatingService service;

    @RequestMapping(value = "/rating/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable(value="id") Long id, @RequestBody RatingDTO ratingDTO) {
        service.update(id, ratingDTO);
    }

    @RequestMapping(value = "/rating", method = RequestMethod.POST)
    public void insert(@RequestBody RatingDTO ratingDTO) {
        service.insert(ratingDTO);
    }

    @RequestMapping(value = "/rating/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value="id") Long id) {
        service.delete(id);
    }
}