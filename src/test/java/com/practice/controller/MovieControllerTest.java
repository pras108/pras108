package com.practice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.practice.model.Movies;
import com.practice.service.ActorService;
import com.practice.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

//@SpringBootTest
@WebMvcTest
//@Disabled
public class MovieControllerTest {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    //remove the below dependency to check for error
    @MockBean
    private ActorService actorService;

    @Autowired
    private ObjectMapper objectMapper;

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
    public void getMovies() throws Exception {

        given(movieService.getAllMoviesFromDB()).willReturn(moviesList);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/movies"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }
}
