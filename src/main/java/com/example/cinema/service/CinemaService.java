package com.example.ThucTapLTS.service;

import com.example.ThucTapLTS.dto.CinemaDTO;
import com.example.ThucTapLTS.entity.*;
import com.example.ThucTapLTS.exception.CinemaNotFoundException;
import com.example.ThucTapLTS.exception.CustomException;
import com.example.ThucTapLTS.repository.CinemaRepository;
import com.example.ThucTapLTS.repository.RoomRepository;
import com.example.ThucTapLTS.repository.ScheduleRepository;
import com.example.ThucTapLTS.repository.SeatRepository;
import com.example.ThucTapLTS.service.imp.CinemaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CinemaService implements CinemaServiceImp {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void addCinema(CinemaEntity cinemaEntity) {
        cinemaRepository.save(cinemaEntity);
        for (RoomEntity data : cinemaEntity.getRoomEntityList()) {
            data.setCinemaEntity(cinemaEntity);
            roomRepository.save(data);
            for (SeatEntity dataSeat : data.getSeatEntityList()) {
                dataSeat.setRoomEntity(data);
                seatRepository.save(dataSeat);
            }
        }
    }

    @Override
    public void editCinema(CinemaEntity cinemaEntity) {
        try {
            Optional<CinemaEntity> cinemaEntityOptional = cinemaRepository.findById(cinemaEntity.getId());
        } catch (Exception e) {
            throw new CinemaNotFoundException("Cinema not found");
        }
        addCinema(cinemaEntity);
    }

    @Override
    public void deleteCinema(int id) {
        try {
            Optional<CinemaEntity> cinemaEntityOptional = cinemaRepository.findById(id);
            CinemaEntity cinemaEntity;
            if (cinemaEntityOptional.isPresent()) {
                cinemaEntity = cinemaEntityOptional.get();
                cinemaEntity.setActive(false);
                cinemaRepository.save(cinemaEntity);
            }
        } catch (Exception ex) {
            throw new CinemaNotFoundException("Cinema not found");
        }
    }

    public List<Object[]> cinemaSalesStatistics(LocalDateTime startTime, LocalDateTime endTime) {
        List<Object[]> objects = cinemaRepository.cinemaSalesStatistics(startTime, endTime);
        for (Object[] obj : objects) {
            CinemaEntity cinemaEntity = (CinemaEntity) obj[0];
            cinemaEntity.setRoomEntityList(null);
        }
        return objects;
    }
}
