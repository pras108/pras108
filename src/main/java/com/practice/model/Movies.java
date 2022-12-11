package com.practice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "movies")
@Data
public class Movies {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    String title;

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", rating='" + rating + '\'' +
                ", plot='" + plot + '\'' +
                ", studio='" + studio + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }

    @Column
    String year;

    @Column
    String rating;

    @Column
    String plot;

    @Column
    String studio;

    @Column
    String poster;
}
