package com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql;

import com.example.researchprojectarchitecture.movie.core.model.Actor;
import com.example.researchprojectarchitecture.movie.core.model.Genre;
import com.example.researchprojectarchitecture.movie.core.model.Movie;
import com.example.researchprojectarchitecture.movie.core.model.Writer;
import com.example.researchprojectarchitecture.movie.core.port.outgoing.MovieRepository;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.ActorEntity;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.GenreEntity;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.MovieEntity;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.WriterEntity;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories.SpringDataMySQLActorRepository;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories.SpringDataMySQLGenreRepository;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories.SpringDataMySQLMovieRepository;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories.SpringDataMySQLWriterRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Primary // Switch between databases by using the @Primary annotation
@Component
public class MySQLDBMovieRepository implements MovieRepository {

    private final SpringDataMySQLMovieRepository springDataMySQLMovieRepository;
    private final SpringDataMySQLActorRepository springDataMySQLActorRepository;
    private final SpringDataMySQLGenreRepository springDataMySQLGenreRepository;
    private final SpringDataMySQLWriterRepository springDataMySQLWriterRepository;

    private final MovieMapper movieMapper;

    public MySQLDBMovieRepository(SpringDataMySQLMovieRepository springDataMySQLMovieRepository, SpringDataMySQLActorRepository springDataMySQLActorRepository, SpringDataMySQLGenreRepository springDataMySQLGenreRepository, SpringDataMySQLWriterRepository springDataMySQLWriterRepository, MovieMapper movieMapper) {
        this.springDataMySQLMovieRepository = springDataMySQLMovieRepository;
        this.springDataMySQLActorRepository = springDataMySQLActorRepository;
        this.springDataMySQLGenreRepository = springDataMySQLGenreRepository;
        this.springDataMySQLWriterRepository = springDataMySQLWriterRepository;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<Movie> getMovies() {
        return movieMapper.mapListMovieEntitiesToListMovies(springDataMySQLMovieRepository.findAll());
    }

    @Override
    public Movie getMovieByString(String str) {
        MovieEntity movieEntity = springDataMySQLMovieRepository.findMovieEntityByMovieId(str);
        return movieMapper.mapMovieEntityToMovie(movieEntity);
    }

    @Override
    public List<Movie> getMoviesWithDurationGreaterThan(int duration) {
        return movieMapper.mapListMovieEntitiesToListMovies(springDataMySQLMovieRepository.getMovieEntitiesByDurationGreaterThan(duration));
    }

    @Override
    public void saveMovie(Movie movie) {
        MovieEntity entity = movieMapper.mapMovieToMovieEntity(movie);
        List<ActorEntity> actorEntityList = entity.getActors();
        List<GenreEntity> genreEntityList = entity.getGenres();
        List<WriterEntity> writerEntityList = entity.getWriters();

        if (actorEntityList != null) {
            for (ActorEntity actorEntity : actorEntityList) {
                boolean exists = springDataMySQLActorRepository.existsByActorId(actorEntity.getActorId());
                if(!exists) {
                    springDataMySQLActorRepository.save(actorEntity);
                }
            }
        }

        if (genreEntityList != null) {
            for (GenreEntity genreEntity : genreEntityList) {
                boolean exists = springDataMySQLGenreRepository.existsByGenresId(genreEntity.getGenresId());
                if (!exists) {
                    springDataMySQLGenreRepository.save(genreEntity);
                }
            }
        }

        if (writerEntityList != null) {
            for (WriterEntity writerEntity : writerEntityList) {
                boolean exists = springDataMySQLWriterRepository.existsByWriterId(writerEntity.getWriterId());
                if (!exists) {
                    springDataMySQLWriterRepository.save(writerEntity);
                }
            }
        }

        springDataMySQLMovieRepository.save(entity);
    }

    @Override
    public void saveActor(Actor actor) {
        ActorEntity entity = movieMapper.mapActorToActorEntity(actor);
        springDataMySQLActorRepository.save(entity);
    }

    @Override
    public void saveGenre(Genre genre) {
        GenreEntity entity = movieMapper.mapGenreToGenreEntity(genre);
        springDataMySQLGenreRepository.save(entity);
    }

    @Override
    public void saveWriter(Writer writer) {
        WriterEntity entity = movieMapper.mapWriterToWriterEntity(writer);
        springDataMySQLWriterRepository.save(entity);
    }

    @Override
    public void deleteMovieById(String id) {
        springDataMySQLMovieRepository.deleteById(id);

    }

    @Override
    public Boolean existsMovieByString(String str) {
        return springDataMySQLMovieRepository.existsByMovieId(str);
    }
}
