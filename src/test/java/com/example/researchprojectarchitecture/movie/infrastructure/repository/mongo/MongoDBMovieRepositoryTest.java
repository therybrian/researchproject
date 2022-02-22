package com.example.researchprojectarchitecture.movie.infrastructure.repository.mongo;

import com.example.researchprojectarchitecture.movie.core.model.Actor;
import com.example.researchprojectarchitecture.movie.core.model.Genre;
import com.example.researchprojectarchitecture.movie.core.model.Movie;
import com.example.researchprojectarchitecture.movie.core.model.Writer;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;
import java.util.List;

//@DataMongoTest
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureDataMongo
class MongoDBMovieRepositoryTest {

    // TODO add tests from MongoDBMovieRepository

    @Autowired
    private SpringDataMongoMovieRepository springDataMongoMovieRepository;

    @Autowired
    private MongoMovieMapper movieMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void setUp() {
        Writer writer1 = new Writer("1", "J.R.R. Tolkien");
        Writer writer2 = new Writer("2", "Fran Walsh");
        Writer writer3 = new Writer("3", "Philippa Boyens");
        Writer writer4 = new Writer("4", "Stephen King");
        Writer writer5 = new Writer("5", "Frank Darabont");
        Genre genre1 = new Genre("1", "Action");
        Genre genre2 = new Genre("2", "Adventure");
        Genre genre3 = new Genre("3",  "Drama");
        Genre genre4 = new Genre("4", "Fantasy");
        Actor actor1 = new Actor(
                "1",
                "Elijah Wood",
                "28/01/1981"
        );
        Actor actor2 = new Actor(
                "2",
                "Ian McKellen",
                "25/03/1939"
        );
        Actor actor3 = new Actor(
                "3",
                "Orlando Bloom",
                "13/01/1977"
        );
        Actor actor4 = new Actor(
                "4",
                "Tim Robbins",
                "16/10/1958"
        );
        Actor actor5 = new Actor(
                "5",
                "Morgan Freeman",
                "01/06/1937"
        );
        Actor actor6 = new Actor(
                "6",
                "Bob Gunton",
                "15/11/1945"
        );

        Movie movie1 = new Movie.MovieBuilder("The Lord of the Rings: The Fellowship of the Ring")
                .movieId("1")
                .ratingImdb(8.8)
                .description("An ancient Ring thought lost for centuries has been found, and through a strange twist of fate has been given to a small Hobbit named Frodo. When Gandalf discovers the Ring is in fact the One Ring of the Dark Lord Sauron, Frodo must make an epic quest to the Cracks of Doom in order to destroy it. However, he does not go alone. He is joined by Gandalf, Legolas the elf, Gimli the Dwarf, Aragorn, Boromir, and his three Hobbit friends Merry, Pippin, and Samwise. Through mountains, snow, darkness, forests, rivers and plains, facing evil and danger at every corner the Fellowship of the Ring must go. Their quest to destroy the One Ring is the only hope for the end of the Dark Lords reign.")
                .genres(List.of(genre1, genre2, genre3, genre4))
                .duration(178)
                .yearOfProduction(2001)
                .director("Peter Jackson")
                .writers(List.of(writer1, writer2, writer3))
                .actors(List.of(actor1, actor2, actor3))
                .build();

//        Movie movie2 = new Movie(
//                "The Shawshank Redemption",
//                9.3,
//                "Chronicles the experiences of a formerly successful banker as a prisoner in the gloomy jailhouse of Shawshank after being found guilty of a crime he did not commit. The film portrays the man's unique way of dealing with his new, torturous life; along the way he befriends a number of fellow prisoners, most notably a wise long-term inmate named Red.—J-S-Golden",
//                List.of("Drama"),
//                144,
//                1994,
//                "Frank Darabont",
//                List.of("Stephen King, Frank Darabont"),
//                List.of(actor5, actor4, actor6)
//        );

        Movie movie2 = new Movie.MovieBuilder("The Shawshank Redemption")
                .movieId("2")
                .ratingImdb(9.3)
                .description("Chronicles the experiences of a formerly successful banker as a prisoner in the gloomy jailhouse of Shawshank after being found guilty of a crime he did not commit. The film portrays the man's unique way of dealing with his new, torturous life; along the way he befriends a number of fellow prisoners, most notably a wise long-term inmate named Red.—J-S-Golden")
                .genres(List.of(genre3))
                .duration(144)
                .yearOfProduction(1994)
                .director("Frank Darabont")
                .writers(List.of(writer4, writer5))
                .actors(List.of(actor5, actor4, actor6))
                .build();

        List<Movie> movies = Arrays.asList(movie1, movie2);
        List<MovieDocument> movieDocumentList = movieMapper.mapListMovieToListMovieDocument(movies);
        springDataMongoMovieRepository.saveAll(movieDocumentList);
    }

    @AfterEach
    void afterEach() {
        mongoTemplate.dropCollection(MovieDocument.class);
    }

    @Test
    void shouldCheckIfMovieExists() {
        // arrange
        String name = "The Lord of the Rings: The Fellowship of the Ring";
        // act
        boolean expected = springDataMongoMovieRepository.existsMovieByName(name);
        // assert
        Assertions.assertTrue(expected);
    }

    @Test
    void shouldFindMovieByDurationGreaterThan() {
        // arrange
        int duration = 120;
        // act
        List<Movie> movies = movieMapper.mapListMovieDocumentToListMovie(springDataMongoMovieRepository.findMovieByDurationGreaterThan(duration));
        // assert
        Assertions.assertTrue(movies.size() > 0);
    }

}