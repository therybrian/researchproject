package com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories;

import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMySQLGenreRepository extends JpaRepository<GenreEntity, String> {

    boolean existsByGenresId (String str);
}
