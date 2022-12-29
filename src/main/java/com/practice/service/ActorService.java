package com.practice.service;

import com.practice.movies.model.Actor;
import com.practice.movies.repository.ActorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    ActorRespository actorRespository;

    public List<Actor> getAllActors() {
        return actorRespository.findAll();
    }
}
