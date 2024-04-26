package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    @Query("SELECT r " +
            "FROM MovieEntity m " +
            "JOIN ScheduleEntity s ON m.id = s.movieEntity.id " +
            "JOIN RoomEntity r ON s.roomEntity.id = r.id " +
            "WHERE m = :movieEntity " +
            "GROUP BY r.id")
    List<RoomEntity> findRoomEntitiesByMovie(MovieEntity movieEntity);

    @Query("SELECT r " +
            "FROM CinemaEntity c " +
            "JOIN RoomEntity r ON c.id = r.cinemaEntity.id " +
            "JOIN ScheduleEntity s ON r.id = s.roomEntity.id " +
            "JOIN MovieEntity m ON m.id = s.movieEntity.id " +
            "WHERE m = :movieEntity AND c = :cinemaEntity" )
    List<RoomEntity> findRoomEntitiesByMovieAndCinema(MovieEntity movieEntity, CinemaEntity cinemaEntity);
}
