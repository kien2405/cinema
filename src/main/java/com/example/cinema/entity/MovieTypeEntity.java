package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movie_type")
public class MovieTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "movie_type_name")
    private String movieTypeName;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "movieTypeEntity")
    private List<MovieEntity> movieEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieTypeName() {
        return movieTypeName;
    }

    public void setMovieTypeName(String movieTypeName) {
        this.movieTypeName = movieTypeName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<MovieEntity> getMovieEntityList() {
        return movieEntityList;
    }

    public void setMovieEntityList(List<MovieEntity> movieEntityList) {
        this.movieEntityList = movieEntityList;
    }
}
