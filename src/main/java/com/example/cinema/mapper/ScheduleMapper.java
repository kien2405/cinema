package com.example.ThucTapLTS.mapper;

import com.example.ThucTapLTS.dto.ScheduleDTO;
import com.example.ThucTapLTS.dto.SeatDTO;
import com.example.ThucTapLTS.entity.MovieEntity;
import com.example.ThucTapLTS.entity.RoomEntity;
import com.example.ThucTapLTS.entity.ScheduleEntity;
import com.example.ThucTapLTS.entity.SeatEntity;
import com.example.ThucTapLTS.repository.MovieRepository;
import com.example.ThucTapLTS.repository.RoomRepository;
import com.example.ThucTapLTS.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ScheduleMapper {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MovieRepository movieRepository;

    public ScheduleDTO toDTO (ScheduleEntity scheduleEntity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setActive(scheduleEntity.isActive());
        scheduleDTO.setCode(scheduleEntity.getCode());
        scheduleDTO.setName(scheduleEntity.getName());
        scheduleDTO.setPrice(scheduleEntity.getPrice());

        if (scheduleEntity.getStartAt() != null) {
            scheduleDTO.setStartAt(scheduleEntity.getStartAt().format(formatter));
        }

        if (scheduleEntity.getEndAt() != null) {
            scheduleDTO.setEndAt(scheduleEntity.getEndAt().format(formatter));
        }

        scheduleDTO.setMovieId(scheduleDTO.getMovieId());
        scheduleDTO.setRoomId(scheduleDTO.getRoomId());

        return scheduleDTO;
    }

    public ScheduleEntity toEntity (ScheduleDTO scheduleDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setActive(scheduleDTO.isActive());
        scheduleEntity.setCode(scheduleDTO.getCode());
        scheduleEntity.setName(scheduleDTO.getName());
        scheduleEntity.setPrice(scheduleDTO.getPrice());

        if (scheduleDTO.getStartAt() != null) {
            LocalDateTime date = LocalDateTime.parse(scheduleDTO.getStartAt(), formatter);
            scheduleEntity.setStartAt(date);
        }

        if (scheduleDTO.getEndAt() != null) {
            LocalDateTime date = LocalDateTime.parse(scheduleDTO.getEndAt(), formatter);
            scheduleEntity.setEndAt(date);
        }

        Optional<RoomEntity> roomEntityOptional = roomRepository.findById(scheduleDTO.getRoomId());
        RoomEntity roomEntity = new RoomEntity();
        if (roomEntityOptional.isPresent()) {
            roomEntity = roomEntityOptional.get();
        }
        scheduleEntity.setRoomEntity(roomEntity);

        Optional<MovieEntity> movieEntityOptional = movieRepository.findById(scheduleDTO.getMovieId());
        MovieEntity movieEntity = new MovieEntity();
        if (movieEntityOptional.isPresent()) {
            movieEntity = movieEntityOptional.get();
        }
        scheduleEntity.setMovieEntity(movieEntity);

        return scheduleEntity;
    }

    public List<ScheduleDTO> toScheduleDTOList (List<ScheduleEntity> scheduleEntityList) {
        List<ScheduleDTO> scheduleDTOList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (ScheduleEntity data : scheduleEntityList) {
            ScheduleDTO scheduleDTO = new ScheduleDTO();
            scheduleDTO.setActive(data.isActive());
            scheduleDTO.setCode(data.getCode());
            scheduleDTO.setName(data.getName());
            scheduleDTO.setPrice(data.getPrice());

            if (data.getStartAt() != null) {
                scheduleDTO.setStartAt(data.getStartAt().format(formatter));
            }

            if (data.getEndAt() != null) {
                scheduleDTO.setEndAt(data.getEndAt().format(formatter));
            }

            scheduleDTO.setMovieId(scheduleDTO.getMovieId());
            scheduleDTO.setRoomId(scheduleDTO.getRoomId());
            scheduleDTOList.add(scheduleDTO);
        }
        return scheduleDTOList;
    }

    public List<ScheduleEntity> toScheduleEntityList (List<ScheduleDTO> scheduleDTOList) {
        List<ScheduleEntity> scheduleEntityList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (ScheduleDTO data : scheduleDTOList) {
            ScheduleEntity scheduleEntity = new ScheduleEntity();
            scheduleEntity.setActive(data.isActive());
            scheduleEntity.setCode(data.getCode());
            scheduleEntity.setName(data.getName());
            scheduleEntity.setPrice(data.getPrice());

            if (data.getStartAt() != null) {
                LocalDateTime date = LocalDateTime.parse(data.getStartAt(), formatter);
                scheduleEntity.setStartAt(date);
            }

            if (data.getEndAt() != null) {
                LocalDateTime date = LocalDateTime.parse(data.getEndAt(), formatter);
                scheduleEntity.setEndAt(date);
            }

            try {
                Optional<RoomEntity> roomEntityOptional = roomRepository.findById(data.getRoomId());
                RoomEntity roomEntity = new RoomEntity();
                if (roomEntityOptional.isPresent()) {
                    roomEntity = roomEntityOptional.get();
                }
                scheduleEntity.setRoomEntity(roomEntity);
            } catch (Exception ex) {

            }

            try {
                Optional<MovieEntity> movieEntityOptional = movieRepository.findById(data.getMovieId());
                MovieEntity movieEntity = new MovieEntity();
                if (movieEntityOptional.isPresent()) {
                    movieEntity = movieEntityOptional.get();
                }
                scheduleEntity.setMovieEntity(movieEntity);
            } catch (Exception ex) {

            }

            scheduleEntityList.add(scheduleEntity);
        }
        return scheduleEntityList;
    }
}
