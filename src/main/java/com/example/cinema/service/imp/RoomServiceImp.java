package com.example.ThucTapLTS.service.imp;

import com.example.ThucTapLTS.entity.MovieEntity;
import com.example.ThucTapLTS.entity.RoomEntity;

import java.util.List;

public interface RoomServiceImp {
    void addRoom(RoomEntity roomEntity);

    void editRoom(RoomEntity roomEntity);

    void deleteRoom(int id);
}
