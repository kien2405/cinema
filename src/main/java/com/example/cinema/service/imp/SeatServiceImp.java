package com.example.ThucTapLTS.service.imp;

import com.example.ThucTapLTS.entity.ScheduleEntity;
import com.example.ThucTapLTS.entity.SeatEntity;

import java.util.List;

public interface SeatServiceImp {
    void addSeat(SeatEntity seatEntity);

    void editSeat(SeatEntity seatEntity);

    void deleteSeat(int id);

    List<SeatEntity> showSeatByScheduleId(int id);
}
