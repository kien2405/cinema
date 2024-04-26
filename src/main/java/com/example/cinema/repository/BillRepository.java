package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Integer> {
}
