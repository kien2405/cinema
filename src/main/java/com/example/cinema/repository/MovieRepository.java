package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    @Query ("SELECT m, COUNT(bt.ticketEntity) AS total_tickets " +
            "FROM MovieEntity m " +
            "JOIN ScheduleEntity s ON m.id = s.movieEntity.id " +
            "JOIN TicketEntity t ON s.id = t.scheduleEntity.id " +
            "JOIN BillTicketEntity bt ON t.id = bt.ticketEntity.id " +
            "JOIN BillEntity b ON b.id = bt.billEntity.id " +
            "JOIN BillStatusEntity bs ON bs.id = b.billStatusEntity.id " +
            "WHERE bs.id = 1 " +
            "GROUP BY m " +
            "ORDER BY total_tickets DESC")
    List<MovieEntity> featuredMovieDisplay();
}
