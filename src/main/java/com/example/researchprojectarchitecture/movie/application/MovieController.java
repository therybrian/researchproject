package com.example.researchprojectarchitecture.movie.application;

import com.example.researchprojectarchitecture.movie.core.model.Movie;
import com.example.researchprojectarchitecture.movie.core.port.incoming.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MovieController {


    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok().body(movieService.getAllMovies());

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id) {
        Movie test = movieService.getMovieById(id);
        return ResponseEntity.ok().body(test);
    }

    @GetMapping("/duration/{duration}")
    public ResponseEntity<List<Movie>> getMoviesWithDurationGreaterThan(@PathVariable int duration) {
        return ResponseEntity.ok().body(movieService.getAllMoviesWithDurationGreaterThan(duration));
    }

    @PostMapping("")
    public ResponseEntity<String> saveMovie(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
        return ResponseEntity.ok("Movie saved");
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> patchMovieName(@PathVariable String id, @RequestBody Movie partialUpdate) {
        movieService.saveMoviePartial(partialUpdate, id);
        return ResponseEntity.ok("Movie updated");
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteMovieById(@PathVariable String id) {
        if (movieService.existsByString(id)) {
            movieService.deleteMovieById(id);
            return ResponseEntity.ok("Movie deleted");
        } else {
            return ResponseEntity.ok("Movie not found");

        }
    }
}
