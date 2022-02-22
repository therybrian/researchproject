package com.example.researchprojectarchitecture.movie.core.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieTest {

    // arrange
    // act
    // assert

    private  String NAME_MOVIE = "The Lord of the Rings: The Fellowship of the Ring";
    private final Movie MOVIE = new Movie.MovieBuilder(NAME_MOVIE).build();

    @Test
    void nameShouldEqualLoTR() {
        Assertions.assertEquals(MOVIE.getName(),NAME_MOVIE);
    }

    @Test
    void nameShouldNotBeEqualLoTR() {
        Assertions.assertNotEquals(MOVIE + "extra", NAME_MOVIE);
    }
}
