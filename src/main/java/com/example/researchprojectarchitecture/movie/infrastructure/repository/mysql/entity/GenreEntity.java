package com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genre")
public class GenreEntity {

    @Id
    @Column(name="genres_id")
    private String genresId;
    @Column(name="genre")
    private String genre;
    @Column(name="genre_movies")
    @ManyToMany(mappedBy = "genres")
    private List<MovieEntity> movies;

    public GenreEntity(){}

    public GenreEntity(String genresId, String genre) {
        this.genresId = genresId;
        this.genre = genre;
    }

    public String getGenresId() {
        return genresId;
    }

    public void setGenresId(String genresId) {
        this.genresId = genresId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }
}
