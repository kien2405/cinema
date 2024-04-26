package com.example.ThucTapLTS.dto;

import java.util.List;

public class MovieDTO {
    private String description;

    private String director;

    private String endTime;

    private String heroImage;

    private String image;

    private String language;

    private int movieDuration;

    private String name;

    private String premiereDate;

    private String trailer;

    private int movieTypeId;

    private int rateId;

    private boolean isActive;

    private List<ScheduleDTO> scheduleDTOList;

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

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getHeroImage() {
        return heroImage;
    }

    public void setHeroImage(String heroImage) {
        this.heroImage = heroImage;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(String premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public int getMovieTypeId() {
        return movieTypeId;
    }

    public void setMovieTypeId(int movieTypeId) {
        this.movieTypeId = movieTypeId;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<ScheduleDTO> getScheduleDTOList() {
        return scheduleDTOList;
    }

    public void setScheduleDTOList(List<ScheduleDTO> scheduleDTOList) {
        this.scheduleDTOList = scheduleDTOList;
    }
}
