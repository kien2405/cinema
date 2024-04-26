package com.example.ThucTapLTS.service;

import com.example.ThucTapLTS.entity.*;
import com.example.ThucTapLTS.exception.CustomException;
import com.example.ThucTapLTS.exception.MovieNotFoundException;
import com.example.ThucTapLTS.exception.RoomNotFoundException;
import com.example.ThucTapLTS.repository.MovieRepository;
import com.example.ThucTapLTS.repository.RoomRepository;
import com.example.ThucTapLTS.repository.ScheduleRepository;
import com.example.ThucTapLTS.repository.SeatRepository;
import com.example.ThucTapLTS.service.imp.RoomServiceImp;
import org.hibernate.tool.schema.internal.SchemaDropperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements RoomServiceImp {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void addRoom(RoomEntity roomEntity) {
        roomRepository.save(roomEntity);
        for (SeatEntity data : roomEntity.getSeatEntityList()) {
            data.setRoomEntity(roomEntity);
            seatRepository.save(data);
        }
        for (ScheduleEntity data : roomEntity.getScheduleEntityList()) {
            data.setRoomEntity(roomEntity);
            scheduleRepository.save(data);
        }
    }

    @Override
    public void editRoom(RoomEntity roomEntity) {
        try {
            Optional<RoomEntity> roomEntityOptional = roomRepository.findById(roomEntity.getId());
        } catch (Exception e) {
            throw new RoomNotFoundException("Room not found");
        }
        addRoom(roomEntity);
    }

    @Override
    public void deleteRoom(int id) {
        try {
            Optional<RoomEntity> roomEntityOptional = roomRepository.findById(id);
            RoomEntity roomEntity = new RoomEntity();
            if (roomEntityOptional.isPresent()) {
                roomEntity = roomEntityOptional.get();
                roomEntity.setActive(false);
                roomRepository.save(roomEntity);
            }
        } catch (Exception ex) {
            throw new RoomNotFoundException("Room not found");
        }
    }
}
