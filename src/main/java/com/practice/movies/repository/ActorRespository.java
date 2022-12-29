package com.practice.movies.repository;


import com.practice.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRespository extends JpaRepository<Actor, Integer> {
}
