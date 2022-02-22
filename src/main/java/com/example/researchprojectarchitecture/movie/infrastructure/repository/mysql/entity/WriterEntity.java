package com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="writer")
public class WriterEntity {

    @Id
    @Column(name="writer_id")
    private String writerId;
    @Column(name="name_writer")
    private String nameWriter;
    @Column(name="writer_movies")
    @ManyToMany(mappedBy = "writers")
    private List<MovieEntity> movies;

    public WriterEntity(){}

    public WriterEntity(String writerId, String nameWriter) {
        this.writerId = writerId;
        this.nameWriter = nameWriter;

    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public String getNameWriter() {
        return nameWriter;
    }

    public void setNameWriter(String nameWriter) {
        this.nameWriter = nameWriter;
    }

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }


}
