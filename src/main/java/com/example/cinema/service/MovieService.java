package com.example.ThucTapLTS.service;

import com.example.ThucTapLTS.entity.*;
import com.example.ThucTapLTS.exception.CinemaNotFoundException;
import com.example.ThucTapLTS.exception.CustomException;
import com.example.ThucTapLTS.exception.MovieNotFoundException;
import com.example.ThucTapLTS.repository.*;
import com.example.ThucTapLTS.service.imp.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService implements MovieServiceImp {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatStatusRepository seatStatusRepository;

    @Override
    public void addMovie(MovieEntity movieEntity) {
        movieRepository.save(movieEntity);
        for (ScheduleEntity data : movieEntity.getScheduleEntityList()) {
            data.setMovieEntity(movieEntity);
            scheduleRepository.save(data);
        }
    }

    @Override
    public void editMovie(MovieEntity movieEntity) {
        try {
            Optional<MovieEntity> movieEntityOptional = movieRepository.findById(movieEntity.getId());
        } catch (Exception e) {
            throw new MovieNotFoundException("Movie not found");
        }
        addMovie(movieEntity);
    }

    @Override
    public void deleteMovie(int id) {
        try {
            Optional<MovieEntity> movieEntityOptional = movieRepository.findById(id);
            MovieEntity movieEntity = new MovieEntity();
            if (movieEntityOptional.isPresent()) {
                movieEntity = movieEntityOptional.get();
                movieEntity.setActive(false);
                movieRepository.save(movieEntity);
            }
        } catch (Exception ex) {
            throw new MovieNotFoundException("Movie not found");
        }
    }

    @Override
    public List<MovieEntity> featuredMovieDisplay() {
        return movieRepository.featuredMovieDisplay();
    }

    @Override
    public List<CinemaEntity> showCinemaRoomSeatByMovieId(int id) {
        List<CinemaEntity> cinemaEntityList = new ArrayList<>();
        MovieEntity movieEntity = new MovieEntity();
        Optional<MovieEntity> movieEntityOptional = movieRepository.findById(id);
        if (movieEntityOptional.isPresent()) {
            movieEntity = movieEntityOptional.get();
        } else {
            throw new MovieNotFoundException("Movie not found");
        }
        List<RoomEntity> roomEntityList = roomRepository.findRoomEntitiesByMovie(movieEntity);

        Set<CinemaEntity> uniqueCinemas = new HashSet<>();

        for (RoomEntity roomEntity : roomEntityList) {
            roomEntity.setScheduleEntityList(new ArrayList<>());
            CinemaEntity cinemaEntity = roomEntity.getCinemaEntity();
            cinemaEntity.setRoomEntityList(Collections.singletonList(roomEntity));
            uniqueCinemas.add(cinemaEntity);
        }

        cinemaEntityList.addAll(uniqueCinemas);

        return cinemaEntityList;
    }

    @Override
    public List<CinemaEntity> showCinemaScheduleByMovieId(int id) throws MovieNotFoundException {
        MovieEntity movieEntity = movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found"));

        List<CinemaEntity> cinemaEntityList = cinemaRepository.findCinemaEntitiesByMovieEntity(movieEntity);
        List<CinemaEntity> cinemaEntitiesFinal = new ArrayList<>();

        for (CinemaEntity dataCinema : cinemaEntityList) {
            dataCinema.setRoomEntityList(roomRepository.findRoomEntitiesByMovieAndCinema(movieEntity, dataCinema));
            for (RoomEntity dataRoom : dataCinema.getRoomEntityList()) {
                dataRoom.setScheduleEntityList(scheduleRepository.findScheduleEntitiesByMovieAndRoom(movieEntity,dataRoom));
                dataRoom.setSeatEntityList(null);
            }
            cinemaEntitiesFinal.add(dataCinema);
        }


        return cinemaEntitiesFinal;
    }
}

