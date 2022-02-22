package com.example.researchprojectarchitecture.movie.core;

import com.example.researchprojectarchitecture.movie.core.model.Actor;
import com.example.researchprojectarchitecture.movie.core.model.Genre;
import com.example.researchprojectarchitecture.movie.core.model.Movie;
import com.example.researchprojectarchitecture.movie.core.model.Writer;
import com.example.researchprojectarchitecture.movie.core.port.outgoing.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieFacadeTest {

    // arrange
    // act
    // assert

    @Mock
    private MovieRepository movieRepository;
    private Movie expected;

    @InjectMocks
    private MovieFacade movieFacade;

    @BeforeEach
    void beforeEach() {
        Writer writer1 = new Writer("1", "J.R.R. Tolkien");
        Writer writer2 = new Writer("2", "Fran Walsh");
        Writer writer3 = new Writer("3", "Philippa Boyens");
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
//        expected = new Movie(
//                "The Lord of the Rings: The Fellowship of the Ring",
//                8.8,
//                "An ancient Ring thought lost for centuries has been found, and through a strange twist of fate has been given to a small Hobbit named Frodo. When Gandalf discovers the Ring is in fact the One Ring of the Dark Lord Sauron, Frodo must make an epic quest to the Cracks of Doom in order to destroy it. However, he does not go alone. He is joined by Gandalf, Legolas the elf, Gimli the Dwarf, Aragorn, Boromir, and his three Hobbit friends Merry, Pippin, and Samwise. Through mountains, snow, darkness, forests, rivers and plains, facing evil and danger at every corner the Fellowship of the Ring must go. Their quest to destroy the One Ring is the only hope for the end of the Dark Lords reign.",
//                List.of("Action", "Adventure", "Drama", "Fantasy"),
//                178,
//                2001,
//                "Peter Jackson",
//                List.of("J.R.R. Tolkien", "Fran Walsh", "Philippa Boyens"),
//                List.of(actor1, actor2, actor3)
//        );
        expected = new Movie.MovieBuilder("The Lord of the Rings: The Fellowship of the Ring")
                .ratingImdb(8.8)
                .description("An ancient Ring thought lost for centuries has been found, and through a strange twist of fate has been given to a small Hobbit named Frodo. When Gandalf discovers the Ring is in fact the One Ring of the Dark Lord Sauron, Frodo must make an epic quest to the Cracks of Doom in order to destroy it. However, he does not go alone. He is joined by Gandalf, Legolas the elf, Gimli the Dwarf, Aragorn, Boromir, and his three Hobbit friends Merry, Pippin, and Samwise. Through mountains, snow, darkness, forests, rivers and plains, facing evil and danger at every corner the Fellowship of the Ring must go. Their quest to destroy the One Ring is the only hope for the end of the Dark Lords reign.")
                .genres(List.of(genre1, genre2, genre3, genre4))
                .duration(178)
                .yearOfProduction(2001)
                .director("Peter Jackson")
                .writers(List.of(writer1, writer2, writer3))
                .actors(List.of(actor1, actor2, actor3))
                .build();
    }

    @Test
    void shouldAddMovie() {
        // arrange
        // act
        Movie result = movieFacade.saveMovie(expected);
        // assert
        Assertions.assertEquals(result, expected);
    }

    @Test
    void shouldSaveMovie() {
        // arrange
        // act
        // assert
        verify(movieRepository, never()).saveMovie(expected);
    }

    @Test
    void shouldThrowWhenMovieNameTaken() {
        // arrange
        given(movieRepository.existsMovieByString(anyString())).willReturn(true);
        // act
        // assert
        ResponseStatusException thrown = Assertions.assertThrows(ResponseStatusException.class,
                () -> movieFacade.saveMovie(expected));

        Assertions.assertTrue(thrown.getMessage().contains("Name : " + expected.getName() + " already exists"));

        verify(movieRepository, never()).saveMovie(any());

    }

}
