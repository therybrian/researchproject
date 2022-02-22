package com.example.researchprojectarchitecture.movie.core.port.incoming;

import com.example.researchprojectarchitecture.movie.core.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieById(String movieId);

    List<Movie> getAllMoviesWithDurationGreaterThan(int duration);

    Movie saveMovie(Movie movie);

    void saveMoviePartial(Movie partialUpdateObject, String id);

    void deleteMovieById(String id);

    Boolean existsByString(String str);




}
