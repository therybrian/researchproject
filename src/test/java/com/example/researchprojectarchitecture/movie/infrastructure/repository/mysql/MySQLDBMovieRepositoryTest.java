package com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql;

import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.ActorEntity;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.GenreEntity;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.MovieEntity;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity.WriterEntity;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories.SpringDataMySQLActorRepository;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories.SpringDataMySQLGenreRepository;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories.SpringDataMySQLMovieRepository;
import com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entityrepositories.SpringDataMySQLWriterRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "classpath:application-test.properties")
class MySQLDBMovieRepositoryTest {

    @Autowired
    SpringDataMySQLMovieRepository sqlMovieRepository;
    @Autowired
    SpringDataMySQLWriterRepository sqlWriterRepository;
    @Autowired
    SpringDataMySQLGenreRepository sqlGenreRepository;
    @Autowired
    SpringDataMySQLActorRepository sqlActorRepository;

    @BeforeEach
    void beforeEach() {

    }

    @AfterEach
    void afterEach() {
//        sqlActorRepository.deleteAll();
//        sqlGenreRepository.deleteAll();
//        sqlWriterRepository.deleteAll();
//        sqlMovieRepository.deleteAll();
    }

    @Test
    @Rollback(value = false)
    void shouldSaveEntity() {
        GenreEntity genre3 = new GenreEntity("3", "Drama");
        WriterEntity writer4 = new WriterEntity("4", "Stephen King");
        WriterEntity writer5 = new WriterEntity("5", "Frank Darabont");
        ActorEntity actor4 = new ActorEntity(
                "4",
                "Tim Robbins",
                "16/10/1958"
        );


        MovieEntity entity = new MovieEntity(
                "1",
                "The Shawshank Redemption",
                9.3,
                "Chronicles the experiences of a formerly successful banker as a prisoner in the gloomy jailhouse of Shawshank after being found guilty of a crime he did not commit. The film portrays the man's unique way of dealing with his new, torturous life; along the way he befriends a number of fellow prisoners, most notably a wise long-term inmate named Red.—J-S-Golden",
                List.of(genre3),
                144,
                1994,
                "Frank Darabont",
                List.of(writer4, writer5),
                List.of(actor4));

        sqlWriterRepository.save(writer4);
        sqlWriterRepository.save(writer5);
        sqlActorRepository.save(actor4);
        sqlGenreRepository.save(genre3);
        sqlMovieRepository.save(entity);
        Assertions.assertTrue(sqlMovieRepository.existsByName("The Shawshank Redemption"));
    }

}