package com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories;

import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataMySQLMovieRepository extends JpaRepository<MovieEntity, String> {

    boolean existsByName (String name);

    boolean existsByMovieId (String name);

    MovieEntity findMovieEntityByMovieId (String str);

    List<MovieEntity> getMovieEntitiesByDurationGreaterThan(int duration);
}
