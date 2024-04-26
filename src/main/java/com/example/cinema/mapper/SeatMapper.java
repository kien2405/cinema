package com.example.ThucTapLTS.mapper;

import com.example.ThucTapLTS.dto.SeatDTO;
import com.example.ThucTapLTS.entity.RoomEntity;
import com.example.ThucTapLTS.entity.SeatEntity;
import com.example.ThucTapLTS.entity.SeatStatusEntity;
import com.example.ThucTapLTS.entity.SeatTypeEntity;
import com.example.ThucTapLTS.repository.RoomRepository;
import com.example.ThucTapLTS.repository.SeatStatusRepository;
import com.example.ThucTapLTS.repository.SeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SeatMapper {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SeatTypeRepository seatTypeRepository;

    @Autowired
    private SeatStatusRepository seatStatusRepository;

    public SeatDTO toDTO (SeatEntity seatEntity) {
        SeatDTO seatDTO = new SeatDTO();
        seatDTO.setActive(seatEntity.isActive());
        seatDTO.setLine(seatEntity.getLine());
        seatDTO.setNumber(seatEntity.getNumber());
        seatDTO.setRoomId(seatEntity.getRoomEntity().getId());
        seatDTO.setSeatStatusId(seatEntity.getSeatStatusEntity().getId());
        seatDTO.setSeatTypeId(seatEntity.getSeatTypeEntity().getId());
        return seatDTO;
    }

    public SeatEntity toEntity (SeatDTO seatDTO) {
        SeatEntity seatEntity = new SeatEntity();
        seatEntity.setActive(seatDTO.isActive());
        seatEntity.setLine(seatDTO.getLine());
        seatEntity.setNumber(seatDTO.getNumber());

        Optional<RoomEntity> roomEntityOptional = roomRepository.findById(seatDTO.getRoomId());
        RoomEntity roomEntity = new RoomEntity();
        if (roomEntityOptional.isPresent()) {
            roomEntity = roomEntityOptional.get();
        }
        seatEntity.setRoomEntity(roomEntity);

        Optional<SeatStatusEntity> seatStatusEntityOptional = seatStatusRepository.findById(seatDTO.getSeatStatusId());
        SeatStatusEntity seatStatusEntity = new SeatStatusEntity();
        if (seatStatusEntityOptional.isPresent()) {
            seatStatusEntity = seatStatusEntityOptional.get();
        }
        seatEntity.setSeatStatusEntity(seatStatusEntity);

        Optional<SeatTypeEntity> seatTypeEntityOptional = seatTypeRepository.findById(seatDTO.getSeatTypeId());
        SeatTypeEntity seatTypeEntity = new SeatTypeEntity();
        if (seatTypeEntityOptional.isPresent()) {
            seatTypeEntity = seatTypeEntityOptional.get();
        }
        seatEntity.setSeatTypeEntity(seatTypeEntity);
        return seatEntity;
    }

    public List<SeatDTO> toSeatDTOList (List<SeatEntity> seatEntityList) {
        List<SeatDTO> seatDTOList = new ArrayList<>();
        for (SeatEntity data : seatEntityList) {
            SeatDTO seatDTO = new SeatDTO();
            seatDTO.setActive(data.isActive());
            seatDTO.setLine(data.getLine());
            seatDTO.setNumber(data.getNumber());
            seatDTO.setRoomId(data.getRoomEntity().getId());
            seatDTO.setSeatStatusId(data.getSeatStatusEntity().getId());
            seatDTO.setSeatTypeId(data.getSeatTypeEntity().getId());
            seatDTOList.add(seatDTO);
        }
        return seatDTOList;
    }

    public List<SeatEntity> toSeatEntityList (List<SeatDTO> seatDTOList) {
        List<SeatEntity> seatEntityList = new ArrayList<>();
        for (SeatDTO data : seatDTOList) {
            SeatEntity seatEntity = new SeatEntity();
            seatEntity.setActive(data.isActive());
            seatEntity.setLine(data.getLine());
            seatEntity.setNumber(data.getNumber());

            try {
                Optional<RoomEntity> roomEntityOptional = roomRepository.findById(data.getRoomId());
                RoomEntity roomEntity = new RoomEntity();
                if (roomEntityOptional.isPresent()) {
                    roomEntity = roomEntityOptional.get();
                }
                seatEntity.setRoomEntity(roomEntity);
            } catch (Exception ex) {

            }

            try {
                Optional<SeatStatusEntity> seatStatusEntityOptional = seatStatusRepository.findById(data.getSeatStatusId());
                SeatStatusEntity seatStatusEntity = new SeatStatusEntity();
                if (seatStatusEntityOptional.isPresent()) {
                    seatStatusEntity = seatStatusEntityOptional.get();
                }
                seatEntity.setSeatStatusEntity(seatStatusEntity);
            } catch (Exception ex) {

            }

            try {
                Optional<SeatTypeEntity> seatTypeEntityOptional = seatTypeRepository.findById(data.getSeatTypeId());
                SeatTypeEntity seatTypeEntity = new SeatTypeEntity();
                if (seatTypeEntityOptional.isPresent()) {
                    seatTypeEntity = seatTypeEntityOptional.get();
                }
                seatEntity.setSeatTypeEntity(seatTypeEntity);
            } catch (Exception ex) {

            }

            seatEntityList.add(seatEntity);
        }
        return seatEntityList;
    }
}
