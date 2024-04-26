package com.example.ThucTapLTS.service;

import com.example.ThucTapLTS.entity.MovieEntity;
import com.example.ThucTapLTS.entity.RoomEntity;
import com.example.ThucTapLTS.entity.ScheduleEntity;
import com.example.ThucTapLTS.entity.SeatEntity;
import com.example.ThucTapLTS.exception.*;
import com.example.ThucTapLTS.repository.ScheduleRepository;
import com.example.ThucTapLTS.repository.SeatRepository;
import com.example.ThucTapLTS.service.imp.SeatServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService implements SeatServiceImp {
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void addSeat(SeatEntity seatEntity) {
        seatRepository.save(seatEntity);
    }

    @Override
    public void editSeat(SeatEntity seatEntity) {
        try {
            Optional<SeatEntity> seatEntityOptional = seatRepository.findById(seatEntity.getId());
        } catch (Exception e) {
            throw new SeatNotFoundException("Seat not found");
        }
        addSeat(seatEntity);
    }

    @Override
    public void deleteSeat(int id) {
        try {
            Optional<SeatEntity> seatEntityOptional = seatRepository.findById(id);
            SeatEntity seatEntity = new SeatEntity();
            if (seatEntityOptional.isPresent()) {
                seatEntity = seatEntityOptional.get();
                seatEntity.setActive(false);
                seatRepository.save(seatEntity);
            }
        } catch (Exception ex) {
            throw new SeatNotFoundException("Seat not found");
        }
    }

    @Override
    public List<SeatEntity> showSeatByScheduleId(int id) throws SeatNotFoundException {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException("Schedule not found"));
        return seatRepository.findSeatEntitiesBySchedule(scheduleEntity);
    }


}
