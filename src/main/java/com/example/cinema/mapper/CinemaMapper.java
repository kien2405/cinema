package com.example.ThucTapLTS.mapper;

import com.example.ThucTapLTS.dto.CinemaDTO;
import com.example.ThucTapLTS.dto.RoomDTO;
import com.example.ThucTapLTS.dto.SeatDTO;
import com.example.ThucTapLTS.entity.CinemaEntity;
import com.example.ThucTapLTS.entity.RoomEntity;
import com.example.ThucTapLTS.entity.SeatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CinemaMapper {
    @Autowired
    private RoomMapper roomMapper;

    public CinemaDTO toDTO (CinemaEntity cinemaEntity) {
        CinemaDTO cinemaDTO = new CinemaDTO();
        cinemaDTO.setAddress(cinemaEntity.getAddress());
        cinemaDTO.setCode(cinemaEntity.getCode());
        cinemaDTO.setDescription(cinemaEntity.getDescription());
        cinemaDTO.setNameOfCinema(cinemaEntity.getNameOfCinema());
        cinemaDTO.setActive(cinemaEntity.isActive());
        try {
            cinemaDTO.setRoomDTOList(roomMapper.toRoomDTOList(cinemaEntity.getRoomEntityList()));
        } catch (Exception e) {

        }
        return cinemaDTO;
    }

    public CinemaEntity toEntity (CinemaDTO cinemaDTO) {
        CinemaEntity cinemaEntity = new CinemaEntity();
        cinemaEntity.setAddress(cinemaDTO.getAddress());
        cinemaEntity.setCode(cinemaDTO.getCode());
        cinemaEntity.setDescription(cinemaDTO.getDescription());
        cinemaEntity.setNameOfCinema(cinemaDTO.getNameOfCinema());
        cinemaEntity.setActive(cinemaDTO.isActive());
        try {
            cinemaEntity.setRoomEntityList(roomMapper.toRoomEntityList(cinemaDTO.getRoomDTOList()));
        } catch (Exception e) {

        }
        return cinemaEntity;
    }

    public List<CinemaDTO> toCinemaDTOList (List<CinemaEntity> cinemaEntityList) {
        List<CinemaDTO> cinemaDTOList = new ArrayList<>();
        for (CinemaEntity data : cinemaEntityList) {
            CinemaDTO cinemaDTO = new CinemaDTO();
            cinemaDTO.setAddress(data.getAddress());
            cinemaDTO.setCode(data.getCode());
            cinemaDTO.setDescription(data.getDescription());
            cinemaDTO.setNameOfCinema(data.getNameOfCinema());
            cinemaDTO.setActive(data.isActive());
            cinemaDTO.setRoomDTOList(roomMapper.toRoomDTOList(data.getRoomEntityList()));
            cinemaDTOList.add(cinemaDTO);
        }
        return cinemaDTOList;
    }

    public List<CinemaEntity> toCinemaEntityList (List<CinemaDTO> cinemaDTOList) {
        List<CinemaEntity> cinemaEntityList = new ArrayList<>();
        for (CinemaDTO data : cinemaDTOList) {
            CinemaEntity cinemaEntity = new CinemaEntity();
            cinemaEntity.setAddress(data.getAddress());
            cinemaEntity.setCode(data.getCode());
            cinemaEntity.setDescription(data.getDescription());
            cinemaEntity.setNameOfCinema(data.getNameOfCinema());
            cinemaEntity.setActive(data.isActive());
            cinemaEntityList.add(cinemaEntity);
        }
        return cinemaEntityList;
    }
}
