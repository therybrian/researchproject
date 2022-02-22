package com.example.researchprojectarchitecture.movie.infrastructure.repository.mongo;

import com.example.researchprojectarchitecture.movie.core.model.Movie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MongoMovieMapper {


    List<Movie> mapListMovieDocumentToListMovie(final List<MovieDocument> movieDocumentList);

    List<MovieDocument> mapListMovieToListMovieDocument(List<Movie> movies);

    MovieDocument mapMovieToMovieDocument(final Movie movie);

    Movie mapMovieDocumentToMovie(final MovieDocument movieDocument);

}
