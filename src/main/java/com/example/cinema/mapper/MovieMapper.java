package com.example.ThucTapLTS.mapper;

import com.example.ThucTapLTS.dto.MovieDTO;
import com.example.ThucTapLTS.dto.RoomDTO;
import com.example.ThucTapLTS.dto.SeatDTO;
import com.example.ThucTapLTS.entity.*;
import com.example.ThucTapLTS.repository.MovieTypeRepository;
import com.example.ThucTapLTS.repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MovieMapper {
    @Autowired
    private MovieTypeRepository movieTypeRepository;

    @Autowired
    private RateRepository rateRepository;

    @Autowired
    private ScheduleMapper scheduleMapper;

    public MovieDTO toDTO (MovieEntity movieEntity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setActive(movieEntity.isActive());
        movieDTO.setDescription(movieEntity.getDescription());
        movieDTO.setDirector(movieEntity.getDirector());
        if (movieEntity.getEndTime() != null) {
            movieDTO.setEndTime(movieEntity.getEndTime().format(formatter));
        }
        movieDTO.setHeroImage(movieEntity.getHeroImage());
        movieDTO.setImage(movieEntity.getImage());
        movieDTO.setLanguage(movieEntity.getLanguage());
        movieDTO.setMovieDuration(movieEntity.getMovieDuration());
        movieDTO.setName(movieEntity.getName());
        if (movieEntity.getPremiereDate() != null) {
            movieDTO.setPremiereDate(movieEntity.getPremiereDate().format(formatter));
        }
        movieDTO.setTrailer(movieEntity.getTrailer());
        movieDTO.setMovieTypeId(movieEntity.getMovieTypeEntity().getId());
        movieDTO.setRateId(movieEntity.getRateEntity().getId());
        movieDTO.setScheduleDTOList(scheduleMapper.toScheduleDTOList(movieEntity.getScheduleEntityList()));
        return movieDTO;
    }

    public MovieEntity toEntity (MovieDTO movieDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setActive(movieDTO.isActive());
        movieEntity.setDescription(movieDTO.getDescription());
        movieEntity.setDirector(movieDTO.getDirector());
        if (movieDTO.getEndTime() != null) {
            LocalDateTime date = LocalDateTime.parse(movieDTO.getEndTime(), formatter);
            movieEntity.setEndTime(date);
        }
        movieEntity.setHeroImage(movieDTO.getHeroImage());
        movieEntity.setImage(movieDTO.getImage());
        movieEntity.setLanguage(movieDTO.getLanguage());
        movieEntity.setMovieDuration(movieDTO.getMovieDuration());
        movieEntity.setName(movieDTO.getName());
        if (movieDTO.getPremiereDate() != null) {
            LocalDateTime date = LocalDateTime.parse(movieDTO.getPremiereDate(), formatter);
            movieEntity.setPremiereDate(date);
        }
        movieEntity.setTrailer(movieDTO.getTrailer());

        Optional<MovieTypeEntity> movieTypeEntityOptional = movieTypeRepository.findById(movieDTO.getMovieTypeId());
        MovieTypeEntity movieTypeEntity = new MovieTypeEntity();
        if (movieTypeEntityOptional.isPresent()) {
            movieTypeEntity = movieTypeEntityOptional.get();
        }
        movieEntity.setMovieTypeEntity(movieTypeEntity);

        Optional<RateEntity> rateEntityOptional = rateRepository.findById(movieDTO.getRateId());
        RateEntity rateEntity = new RateEntity();
        if (rateEntityOptional.isPresent()) {
            rateEntity = rateEntityOptional.get();
        }
        movieEntity.setRateEntity(rateEntity);
        movieEntity.setScheduleEntityList(scheduleMapper.toScheduleEntityList(movieDTO.getScheduleDTOList()));

        return movieEntity;
    }

    public List<MovieDTO> toMovieDTOList (List<MovieEntity> movieEntityList) {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (MovieEntity data : movieEntityList) {
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setActive(data.isActive());
            movieDTO.setDescription(data.getDescription());
            movieDTO.setDirector(data.getDirector());
            if (data.getEndTime() != null) {
                movieDTO.setEndTime(data.getEndTime().format(formatter));
            }
            movieDTO.setHeroImage(data.getHeroImage());
            movieDTO.setImage(data.getImage());
            movieDTO.setLanguage(data.getLanguage());
            movieDTO.setMovieDuration(data.getMovieDuration());
            movieDTO.setName(data.getName());
            if (data.getPremiereDate() != null) {
                movieDTO.setPremiereDate(data.getPremiereDate().format(formatter));
            }
            movieDTO.setTrailer(data.getTrailer());
            movieDTO.setMovieTypeId(data.getMovieTypeEntity().getId());
            movieDTO.setRateId(data.getRateEntity().getId());
            try {
                movieDTO.setScheduleDTOList(scheduleMapper.toScheduleDTOList(data.getScheduleEntityList()));
            } catch (Exception e) {

            }
            movieDTOList.add(movieDTO);
        }
        return movieDTOList;
    }
}
