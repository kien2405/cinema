package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.RoomEntity;
import com.example.ThucTapLTS.entity.ScheduleEntity;
import com.example.ThucTapLTS.entity.SeatEntity;
import com.example.ThucTapLTS.entity.SeatStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, Integer> {
    @Query("SELECT seat " +
            "FROM ScheduleEntity s " +
            "JOIN RoomEntity r ON s.roomEntity.id = r.id " +
            "JOIN SeatEntity seat ON seat.roomEntity.id = r.id " +
            "WHERE s = :scheduleEntity " +
            "GROUP BY seat"
            )
    List<SeatEntity> findSeatEntitiesBySchedule(ScheduleEntity scheduleEntity);
}
