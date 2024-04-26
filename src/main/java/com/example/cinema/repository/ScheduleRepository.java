package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.CinemaEntity;
import com.example.ThucTapLTS.entity.MovieEntity;
import com.example.ThucTapLTS.entity.RoomEntity;
import com.example.ThucTapLTS.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Integer> {
    List<ScheduleEntity> findScheduleEntitiesByMovieEntity(MovieEntity movieEntity);

    @Query("SELECT s " +
            "FROM RoomEntity r " +
            "JOIN ScheduleEntity s ON r.id = s.roomEntity.id " +
            "JOIN MovieEntity m ON m.id = s.movieEntity.id " +
            "WHERE m = :movieEntity AND r = :roomEntity" )
    List<ScheduleEntity> findScheduleEntitiesByMovieAndRoom(MovieEntity movieEntity, RoomEntity roomEntity);
}
