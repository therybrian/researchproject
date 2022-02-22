package com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories;

import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.WriterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMySQLWriterRepository extends JpaRepository<WriterEntity, String> {

    boolean existsByWriterId (String str);
}
