package com.practice.util;

import com.practice.movies.model.Movies;

import java.util.Comparator;

public class MyComparator implements Comparator<Movies> {

   /* @Override
    public int compare(Object o1, Object o2) {
        Movies m1 = (Movies) o1;
        Movies m2 = (Movies) o2;
        return Integer.compare(m1.getId(), m2.getId());
    }*/

    @Override
    public int compare(Movies o1, Movies o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
