package com.practice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "actors")
@Data
public class Actor {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    String name;
}
