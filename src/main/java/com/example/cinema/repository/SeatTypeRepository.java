package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.SeatTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatTypeEntity, Integer> {
}
