package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rate")
public class RateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "rateEntity")
    private List<MovieEntity> movieEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<MovieEntity> getMovieEntityList() {
        return movieEntityList;
    }

    public void setMovieEntityList(List<MovieEntity> movieEntityList) {
        this.movieEntityList = movieEntityList;
    }
}
