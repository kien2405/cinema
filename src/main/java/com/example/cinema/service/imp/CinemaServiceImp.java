package com.example.ThucTapLTS.service.imp;

import com.example.ThucTapLTS.dto.CinemaDTO;
import com.example.ThucTapLTS.entity.CinemaEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CinemaServiceImp {
    void addCinema(CinemaEntity cinemaEntity);

    void editCinema(CinemaEntity cinemaEntity);

    void deleteCinema(int id);

    List<Object[]> cinemaSalesStatistics(LocalDateTime startTime, LocalDateTime endTime);
}
