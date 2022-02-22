package com.example.researchprojectarchitecture.movie.core;

import com.example.researchprojectarchitecture.movie.core.model.Movie;
import com.example.researchprojectarchitecture.movie.core.port.incoming.MovieService;
import com.example.researchprojectarchitecture.movie.core.port.outgoing.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class MovieFacade implements MovieService {

    private final MovieRepository movieRepository;

    public MovieFacade(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getMovies();
    }

    @Override
    public Movie getMovieById(String movieId) {
        return movieRepository.getMovieByString(movieId);
    }

    @Override
    public List<Movie> getAllMoviesWithDurationGreaterThan(int duration) {
        return movieRepository.getMoviesWithDurationGreaterThan(duration);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        Boolean existNameMovie = movieRepository.existsMovieByString(movie.getName());
        if (existNameMovie) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,  "Name : " + movie.getName() + " already exists");
        }
        movieRepository.saveMovie(movie);
        return movie;
    }

    @Override
    public void saveMoviePartial(Movie partialUpdateObject, String id) {
        movieRepository.saveMovie(partialUpdateObject);
    }

    @Override
    public void deleteMovieById(String id) {
        movieRepository.deleteMovieById(id);
    }

    @Override
    public Boolean existsByString(String str) {
        return movieRepository.existsMovieByString(str);
    }
}
