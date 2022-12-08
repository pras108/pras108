package com.practice.service;

import com.practice.model.Movies;
import com.practice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movies> getAllMoviesFromDB() {
        return movieRepository.findAll();
    }

    public Page<Movies> getPagedResultsForMovies(int pageNo, int size) {
        PageRequest pageRequest = PageRequest.of(pageNo, size);
        return movieRepository.findAll(pageRequest);
    }
}
