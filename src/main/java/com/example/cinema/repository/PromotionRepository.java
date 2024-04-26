package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {
}
