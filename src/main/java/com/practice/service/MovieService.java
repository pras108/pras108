package com.practice.service;

import com.practice.movies.model.Movies;
import com.practice.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        if (pageNo < 0) {
            throw new RuntimeException("Invalid request Parameters!");
        }
        PageRequest pageRequest = PageRequest.of(pageNo, size);
        return movieRepository.findAll(pageRequest);
    }

    public Page<Movies> getPagedAndSortedResultsForMovies(int pageNo, int size) {
        if (pageNo < 0) {
            throw new RuntimeException("Invalid request Parameters!");
        }
        return movieRepository.findAll(PageRequest.of(pageNo, size, Sort.by(Sort.Direction.ASC, "id")));
    }
}
