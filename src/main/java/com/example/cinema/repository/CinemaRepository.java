package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.CinemaEntity;
import com.example.ThucTapLTS.entity.MovieEntity;
import com.example.ThucTapLTS.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<CinemaEntity, Integer> {
    @Query("SELECT c " +
            "FROM CinemaEntity c " +
            "JOIN RoomEntity r ON c.id = r.cinemaEntity.id " +
            "JOIN ScheduleEntity s ON r.id = s.roomEntity.id " +
            "JOIN MovieEntity m ON m.id = s.movieEntity.id " +
            "WHERE m = :movieEntity " +
            "GROUP BY c")
    List<CinemaEntity> findCinemaEntitiesByMovieEntity(MovieEntity movieEntity);

    @Query("SELECT c, SUM(b.totalMoney) AS TongDoanhThu " +
            "FROM CinemaEntity c " +
            "JOIN RoomEntity r ON c.id = r.cinemaEntity.id " +
            "JOIN ScheduleEntity s ON r.id = s.roomEntity.id " +
            "JOIN TicketEntity t ON t.scheduleEntity.id = s.id " +
            "JOIN BillTicketEntity bt ON bt.ticketEntity.id = t.id " +
            "JOIN BillEntity b ON b.id = bt.billEntity.id " +
            "WHERE b.createTime >= :startTime AND b.createTime <= :endTime AND b.billStatusEntity.id = 1 " +
            "GROUP BY c")
    List<Object[]> cinemaSalesStatistics(@Param("startTime") LocalDateTime startTime,
                                         @Param("endTime") LocalDateTime endTime);


}
