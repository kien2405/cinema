package com.example.ThucTapLTS.service.imp;

import com.example.ThucTapLTS.entity.CinemaEntity;
import com.example.ThucTapLTS.entity.MovieEntity;

import java.util.List;

public interface MovieServiceImp {
    void addMovie(MovieEntity movieEntity);

    void editMovie(MovieEntity movieEntity);

    void deleteMovie(int id);

    List<MovieEntity> featuredMovieDisplay();

    List<CinemaEntity> showCinemaRoomSeatByMovieId(int id);

    List<CinemaEntity> showCinemaScheduleByMovieId(int id);
}
