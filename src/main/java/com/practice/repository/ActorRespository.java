package com.practice.repository;

import com.practice.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRespository extends JpaRepository<Actor, Integer> {
}
