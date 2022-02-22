package com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories;

import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMySQLActorRepository extends JpaRepository<ActorEntity, String> {
    boolean existsByActorId(String str);
}
