package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "movie_duration")
    private int movieDuration;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "premiere_date")
    private LocalDateTime premiereDate;

    @Column(name = "description")
    private String description;

    @Column(name = "director")
    private String director;

    @Column(name = "image")
    private String image;

    @Column(name = "hero_image")
    private String heroImage;

    @Column(name = "language")
    private String language;

    @Column(name = "name")
    private String name;

    @Column(name = "trailer")
    private String trailer;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "rate_id")
    private RateEntity rateEntity;

    @ManyToOne
    @JoinColumn(name = "movie_type_id")
    private MovieTypeEntity movieTypeEntity;

    @OneToMany(mappedBy = "movieEntity")
    List<ScheduleEntity> scheduleEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(LocalDateTime premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(String heroImage) {
        this.heroImage = heroImage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public RateEntity getRateEntity() {
        return rateEntity;
    }

    public void setRateEntity(RateEntity rateEntity) {
        this.rateEntity = rateEntity;
    }

    public MovieTypeEntity getMovieTypeEntity() {
        return movieTypeEntity;
    }

    public void setMovieTypeEntity(MovieTypeEntity movieTypeEntity) {
        this.movieTypeEntity = movieTypeEntity;
    }

    public List<ScheduleEntity> getScheduleEntityList() {
        return scheduleEntityList;
    }

    public void setScheduleEntityList(List<ScheduleEntity> scheduleEntityList) {
        this.scheduleEntityList = scheduleEntityList;
    }
}
