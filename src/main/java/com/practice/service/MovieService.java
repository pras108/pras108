package com.practice.service;

import com.practice.model.Movies;
import com.practice.repository.MovieRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRespository movieRespository;

    public List<Movies> getAllMoviesFromDB() {
        List<Movies> movies = new ArrayList<>();
        movies = movieRespository.findAll();
        return movies;
    }
}
