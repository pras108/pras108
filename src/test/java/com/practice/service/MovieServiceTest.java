package com.practice.service;

import com.practice.movies.model.Movies;
import com.practice.movies.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieService movieService;

    private static List<Movies> moviesList = new ArrayList<>();

    @BeforeAll
    public static void prepareData() {
        prepareMovieData();
    }

    private static void prepareMovieData() {

        Movies m1 = new Movies();
        m1.setId(1);
        m1.setTitle("Harry Potter and the Sorcerer''s Stone");
        m1.setYear("2001");
        m1.setPlot("An orphaned boy enrolls in a school of wizardry, where he learns the truth about himself, " +
                "his family and the terrible evil that haunts the magical world.");
        m1.setStudio("Heyday Films, Warner Brothers, 1492 Pictures");
        m1.setPoster("harrypotterandthesorcerersstone.jpg");

        Movies m2 = new Movies();
        m2.setId(2);
        m2.setTitle("Harry Potter and the Chamber of Secrets");
        m2.setYear("2002");
        m2.setPlot("An ancient prophecy seems to be coming true when a mysterious presence begins stalking the corridors " +
                "of a school of magic and leaving its victims paralyzed.");
        m2.setStudio("Heyday Films, Warner Brothers, 1492 Pictures");
        m2.setPoster("harrypotterandthechamberofsecrets.jpg");

        Movies m3 = new Movies();
        m3.setId(3);
        m3.setTitle("Harry Potter and the Prisoner of Azkaban");
        m3.setYear("2004");
        m3.setPlot("Harry Potter, Ron and Hermione return to Hogwarts School of Witchcraft and Wizardry for their third year of study, " +
                "where they delve into the mystery surrounding an escaped prisoner who poses a dangerous threat to the young wizard.");
        m3.setStudio("Heyday Films, Warner Brothers, 1492 Pictures");
        m3.setPoster("harrypotterandtheprisonerofazkaban.jpg");

        moviesList.add(m1);
        moviesList.add(m2);
        moviesList.add(m3);
    }

    @Test
    public void testGetAllMovies() {
        Mockito.when(movieRepository.findAll()).thenReturn(moviesList);
        List<Movies> allMoviesFromDB = movieService.getAllMoviesFromDB();
        Assertions.assertNotNull(allMoviesFromDB);
        Assertions.assertEquals(3, allMoviesFromDB.size());
        Assertions.assertEquals("Harry Potter and the Chamber of Secrets", allMoviesFromDB.get(1).getTitle());
    }

    @Test
    public void testGetAllPagedMovies() {
        Page<Movies> page = new PageImpl<>(moviesList);
        Mockito.when(movieRepository.findAll(PageRequest.of(0, 3))).thenReturn(page);
        Page<Movies> pagedResultsForMovies = movieService.getPagedResultsForMovies(0, 3);
        Assertions.assertNotNull(pagedResultsForMovies);
        Assertions.assertEquals(3, pagedResultsForMovies.getContent().size());
    }
}
