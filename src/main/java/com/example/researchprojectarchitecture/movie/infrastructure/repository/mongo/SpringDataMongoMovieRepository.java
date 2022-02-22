package com.example.researchprojectarchitecture.movie.infrastructure.repository.mongo;

import com.example.researchprojectarchitecture.movie.core.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataMongoMovieRepository extends MongoRepository<MovieDocument, String> {

    MovieDocument getMovieDocumentByMovieId(String str);

    List<MovieDocument> findMovieByDurationGreaterThan(int duration);

    Boolean existsMovieByName(String name);

    Boolean existsMovieDocumentByMovieId(String name);

}
