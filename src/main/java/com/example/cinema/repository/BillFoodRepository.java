package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.BillFoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillFoodRepository extends JpaRepository<BillFoodEntity, Integer> {
}
