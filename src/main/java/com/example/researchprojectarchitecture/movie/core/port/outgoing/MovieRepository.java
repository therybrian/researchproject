package com.example.researchprojectarchitecture.movie.core.port.outgoing;

import com.example.researchprojectarchitecture.movie.core.model.Actor;
import com.example.researchprojectarchitecture.movie.core.model.Genre;
import com.example.researchprojectarchitecture.movie.core.model.Movie;
import com.example.researchprojectarchitecture.movie.core.model.Writer;

import java.util.List;

public interface MovieRepository {

    List<Movie> getMovies();

    Movie getMovieByString(String str);

    List<Movie> getMoviesWithDurationGreaterThan(int duration);

    void deleteMovieById(String id);

    Boolean existsMovieByString(String str);

    void saveMovie(Movie movie);

    void saveActor(Actor actor);

    void saveGenre(Genre genre);

    void saveWriter(Writer writer);


}
