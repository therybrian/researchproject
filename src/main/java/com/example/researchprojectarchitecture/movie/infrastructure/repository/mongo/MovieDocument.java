package com.example.researchprojectarchitecture.movie.infrastructure.repository.mongo;

import com.example.researchprojectarchitecture.movie.core.model.Actor;
import com.example.researchprojectarchitecture.movie.core.model.Genre;
import com.example.researchprojectarchitecture.movie.core.model.Movie;
import com.example.researchprojectarchitecture.movie.core.model.Writer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document()
public class MovieDocument {

    @Id
    private String movieId;
    private String name;
    private double ratingImdb;
    private String description;
    private List<Genre> genres;
    private int duration;
    private int yearOfProduction;
    private String director;
    private List<Writer> writers;
    private List<Actor> actors;

    public MovieDocument(){}

    public MovieDocument(String movieId, String name, double ratingImdb, String description, List<Genre> genres, int duration, int yearOfProduction, String director, List<Writer> writers, List<Actor> actors) {
        this.movieId = movieId;
        this.name = name;
        this.ratingImdb = ratingImdb;
        this.description = description;
        this.genres = genres;
        this.duration = duration;
        this.yearOfProduction = yearOfProduction;
        this.director = director;
        this.writers = writers;
        this.actors = actors;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRatingImdb() {
        return ratingImdb;
    }

    public void setRatingImdb(double ratingImdb) {
        this.ratingImdb = ratingImdb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
