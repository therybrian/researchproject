package com.example.researchprojectarchitecture.movie.infrastructure.repository.mysql.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="actor")
public class ActorEntity {

    @Id
    @Column(name="actor_id")
    private String actorId;
    @Column(name="name_actor")
    private String nameActor;
    @Column(name="year_born")
    private String yearBorn;
    @Column(name="actor_movies")
    @ManyToMany(mappedBy = "actors")
    private List<MovieEntity> movies;

    public ActorEntity() {
    }

    public ActorEntity(String actorId, String nameActor, String yearBorn) {
        this.actorId = actorId;
        this.nameActor = nameActor;
        this.yearBorn = yearBorn;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getNameActor() {
        return nameActor;
    }

    public void setNameActor(String nameActor) {
        this.nameActor = nameActor;
    }

    public String getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(String yearBorn) {
        this.yearBorn = yearBorn;
    }

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }


}
