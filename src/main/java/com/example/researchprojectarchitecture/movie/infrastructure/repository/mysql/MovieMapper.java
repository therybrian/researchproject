package com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql;

import com.example.researchprojectarchitecture.movie.core.model.Actor;
import com.example.researchprojectarchitecture.movie.core.model.Genre;
import com.example.researchprojectarchitecture.movie.core.model.Movie;
import com.example.researchprojectarchitecture.movie.core.model.Writer;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.ActorEntity;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.GenreEntity;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.MovieEntity;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.WriterEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieEntity mapMovieToMovieEntity(Movie movie);

    ActorEntity mapActorToActorEntity(Actor actor);

    GenreEntity mapGenreToGenreEntity(Genre genre);

    WriterEntity mapWriterToWriterEntity(Writer writer);

    Movie mapMovieEntityToMovie(final MovieEntity movieEntity);

    List<Movie> mapListMovieEntitiesToListMovies(final List<MovieEntity> movieEntityList);
}
