package com.example.researchprojectarchitecture.movie.infrastructure.repository.mongo;

import com.example.researchprojectarchitecture.movie.core.model.Actor;
import com.example.researchprojectarchitecture.movie.core.model.Genre;
import com.example.researchprojectarchitecture.movie.core.model.Movie;
import com.example.researchprojectarchitecture.movie.core.model.Writer;
import com.example.researchprojectarchitecture.movie.core.port.outgoing.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

// Adapter

@Primary // Switch between databases by using the @Primary annotation,  deze annotatie zorgt voor een hogere voorkeur bij een bean wanneer er meerdere van dezelfde beans zijn.
@Component
public class MongoDBMovieRepository implements MovieRepository {

    private final SpringDataMongoMovieRepository movieRepository;

    private final MongoMovieMapper movieMapper;

    @Autowired
    public MongoDBMovieRepository(SpringDataMongoMovieRepository movieRepository, MongoMovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> movieList = movieMapper.mapListMovieDocumentToListMovie(movieRepository.findAll());
        return movieList;
    }

    @Override
    public Movie getMovieByString(String str) {
        Movie movie = movieMapper.mapMovieDocumentToMovie(movieRepository.getMovieDocumentByMovieId(str));
        return movie;
    }

    @Override
    public List<Movie> getMoviesWithDurationGreaterThan(int duration) {
        List<Movie> movieList = movieMapper.mapListMovieDocumentToListMovie(movieRepository.findMovieByDurationGreaterThan(duration));
        return movieList;
    }

    @Override
    public void saveMovie(Movie movie) {
        MovieDocument movieDocument = movieMapper.mapMovieToMovieDocument(movie);
        movieRepository.save(movieDocument);
    }

    @Override
    public void saveActor(Actor actor) {
    }

    @Override
    public void saveGenre(Genre genre) {

    }

    @Override
    public void saveWriter(Writer writer) {

    }


    @Override
    public void deleteMovieById(String id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Boolean existsMovieByString(String str) {
        return movieRepository.existsMovieDocumentByMovieId(str);
    }
}
