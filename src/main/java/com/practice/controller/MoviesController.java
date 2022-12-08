package com.practice.controller;

import com.practice.model.Movies;
import com.practice.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class MoviesController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public ResponseEntity<String> getAllMovies() {
        String response = "Welcome to Movies Controller";
        log.info(response);
        List<Movies> allMoviesFromDB = movieService.getAllMoviesFromDB();
        log.info("size of movies list: {}", allMoviesFromDB.size());
        return new ResponseEntity<>(allMoviesFromDB.toString(), HttpStatus.OK);
    }

    @GetMapping("/pagedMovies")
    public ResponseEntity<String> getPagedMovies(@RequestParam("pageNo") int pageNo,
                                                 @RequestParam("size") int size) throws Exception{
        Page<Movies> pagedResultsForMovies = movieService.getPagedResultsForMovies(pageNo, size);
        log.info("size of paged movies : {}", pagedResultsForMovies.stream().count());
        return new ResponseEntity<>(pagedResultsForMovies.getContent().toString(), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> throwGenericException(Exception exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
