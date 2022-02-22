package com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

// Will only be using OneToMany relations

@Entity
@Table(name = "movie")
public class MovieEntity {
    // TODO add fields

    @Id
//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "movie_id")
    private String movieId;
    @Column(name = "name")
    private String name;
    @Column(name = "rating_imdb")
    private double ratingImdb;
    @Column(length = 10000)
    private String description;
    @Column(name = "genres")
    @ManyToMany()
    @JoinTable(name = "movie_genre", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genres_id"))
    private List<GenreEntity> genres;
    @Column(name = "duration")
    private int duration;
    @Column(name = "year_of_production")
    private int yearOfProduction;
    @Column(name = "director")
    private String director;
    @Column(name = "writers")
    @ManyToMany()
    @JoinTable(name = "movie_writer", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "writer_id"))
    private List<WriterEntity> writers;
    @Column(name = "actors")
    @ManyToMany()
    @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<ActorEntity> actors;


    public MovieEntity() {
    }

    public MovieEntity(String movieId,
                       String name,
                       double ratingImdb,
                       String description,
                       List<GenreEntity> genres,
                       int duration,
                       int yearOfProduction,
                       String director,
                       List<WriterEntity> writers,
                       List<ActorEntity> actors) {
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

    public List<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(List<GenreEntity> genres) {
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

    public List<WriterEntity> getWriters() {
        return writers;
    }

    public void setWriters(List<WriterEntity> writers) {
        this.writers = writers;
    }

    public List<ActorEntity> getActors() {
        return actors;
    }

    public void setActors(List<ActorEntity> actors) {
        this.actors = actors;
    }
}
