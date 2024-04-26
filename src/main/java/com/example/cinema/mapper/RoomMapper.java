package com.example.ThucTapLTS.mapper;

import com.example.ThucTapLTS.dto.CinemaDTO;
import com.example.ThucTapLTS.dto.RoomDTO;
import com.example.ThucTapLTS.dto.ScheduleDTO;
import com.example.ThucTapLTS.entity.CinemaEntity;
import com.example.ThucTapLTS.entity.RoomEntity;
import com.example.ThucTapLTS.entity.ScheduleEntity;
import com.example.ThucTapLTS.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RoomMapper {
    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private ScheduleMapper scheduleMapper;

    public RoomDTO toDTO (RoomEntity roomEntity) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setActive(roomEntity.isActive());
        roomDTO.setCapacity(roomEntity.getCapacity());
        roomDTO.setCode(roomEntity.getCode());
        roomDTO.setDescription(roomEntity.getDescription());
        roomDTO.setName(roomEntity.getName());
        roomDTO.setType(roomEntity.getType());
        roomDTO.setCinemaId(roomEntity.getCinemaEntity().getId());
        ScheduleMapper scheduleMapper = new ScheduleMapper();
        roomDTO.setScheduleDTOList(scheduleMapper.toScheduleDTOList(roomEntity.getScheduleEntityList()));
        SeatMapper seatMapper = new SeatMapper();
        roomDTO.setSeatDTOList(seatMapper.toSeatDTOList(roomEntity.getSeatEntityList()));
        return roomDTO;
    }

    public RoomEntity toEntity (RoomDTO roomDTO) {
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setActive(roomDTO.isActive());
        roomEntity.setCapacity(roomDTO.getCapacity());
        roomEntity.setCode(roomDTO.getCode());
        roomEntity.setDescription(roomDTO.getDescription());
        roomEntity.setName(roomDTO.getName());
        roomEntity.setType(roomDTO.getType());

        Optional<CinemaEntity> cinemaEntityOptional = cinemaRepository.findById(roomDTO.getCinemaId());
        CinemaEntity cinemaEntity = new CinemaEntity();
        if (cinemaEntityOptional.isPresent()) {
            cinemaEntity = cinemaEntityOptional.get();
        }

        roomEntity.setCinemaEntity(cinemaEntity);

        roomEntity.setScheduleEntityList(scheduleMapper.toScheduleEntityList(roomDTO.getScheduleDTOList()));

        roomEntity.setSeatEntityList(seatMapper.toSeatEntityList(roomDTO.getSeatDTOList()));

        return roomEntity;
    }

    public List<RoomDTO> toRoomDTOList (List<RoomEntity> roomEntityList) {
        List<RoomDTO> roomDTOList = new ArrayList<>();
        for (RoomEntity data : roomEntityList) {
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setActive(data.isActive());
            roomDTO.setCapacity(data.getCapacity());
            roomDTO.setCode(data.getCode());
            roomDTO.setDescription(data.getDescription());
            roomDTO.setName(data.getName());
            roomDTO.setType(data.getType());
            roomDTO.setCinemaId(data.getCinemaEntity().getId());
            try {
                roomDTO.setScheduleDTOList(scheduleMapper.toScheduleDTOList(data.getScheduleEntityList()));
            } catch (Exception e) {

            }
            try {
                roomDTO.setSeatDTOList(seatMapper.toSeatDTOList(data.getSeatEntityList()));
            } catch (Exception e) {

            }
            roomDTOList.add(roomDTO);
        }
        return roomDTOList;
    }

    public List<RoomEntity> toRoomEntityList (List<RoomDTO> roomDTOList) {
        List<RoomEntity> roomEntityList = new ArrayList<>();
        for (RoomDTO data : roomDTOList) {
            RoomEntity roomEntity = new RoomEntity();
            roomEntity.setActive(data.isActive());
            roomEntity.setCapacity(data.getCapacity());
            roomEntity.setCode(data.getCode());
            roomEntity.setDescription(data.getDescription());
            roomEntity.setName(data.getName());
            roomEntity.setType(data.getType());

            try {
                Optional<CinemaEntity> cinemaEntityOptional = cinemaRepository.findById(data.getCinemaId());
                CinemaEntity cinemaEntity = new CinemaEntity();
                if (cinemaEntityOptional.isPresent()) {
                    cinemaEntity = cinemaEntityOptional.get();
                }
                roomEntity.setCinemaEntity(cinemaEntity);
            } catch (Exception ex) {

            }

            try {
                roomEntity.setScheduleEntityList(scheduleMapper.toScheduleEntityList(data.getScheduleDTOList()));
            } catch (Exception e) {

            }

            try {
                roomEntity.setSeatEntityList(seatMapper.toSeatEntityList(data.getSeatDTOList()));
            } catch (Exception e) {

            }

            roomEntityList.add(roomEntity);
        }
        return roomEntityList;
    }
}
