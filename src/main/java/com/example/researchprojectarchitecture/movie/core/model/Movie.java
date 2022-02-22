package com.example.researchprojectarchitecture.movie.core.model;


import java.util.List;

public class Movie {

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

    public Movie() {
    }

    private Movie(MovieBuilder builder) {
        this.movieId = builder.movieId;
        this.name = builder.name;
        this.ratingImdb = builder.ratingImdb;
        this.description = builder.description;
        this.genres = builder.genres;
        this.duration = builder.duration;
        this.yearOfProduction = builder.yearOfProduction;
        this.director = builder.director;
        this.writers = builder.writers;
        this.actors = builder.actors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public void setRatingImdb(double ratingImdb) {
        this.ratingImdb = ratingImdb;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public double getRatingImdb() {
        return ratingImdb;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public int getDuration() {
        return duration;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getDirector() {
        return director;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public static class MovieBuilder {
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

        public MovieBuilder(String name) {
            this.name = name;
        }

        public MovieBuilder movieId(String movieId) {
            this.movieId = movieId;
            return this;
        }

        public MovieBuilder ratingImdb(double ratingImdb) {
            this.ratingImdb = ratingImdb;
            return this;
        }

        public MovieBuilder description(String description) {
            this.description = description;
            return this;
        }

        public MovieBuilder genres(List<Genre> genres) {
            this.genres = genres;
            return this;
        }

        public MovieBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public MovieBuilder yearOfProduction(int yearOfProduction) {
            this.yearOfProduction = yearOfProduction;
            return this;
        }

        public MovieBuilder director(String director) {
            this.director = director;
            return this;
        }

        public MovieBuilder writers(List<Writer> writers) {
            this.writers = writers;
            return this;
        }

        public MovieBuilder actors(List<Actor> actors) {
            this.actors = actors;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }


}
