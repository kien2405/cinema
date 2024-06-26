package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.SeatEntity;
import com.example.ThucTapLTS.entity.SeatStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatStatusRepository extends JpaRepository<SeatStatusEntity, Integer> {
    List<SeatStatusEntity> findSeatStatusEntityBySeatEntityList(List<SeatEntity> seatEntityList);
}
