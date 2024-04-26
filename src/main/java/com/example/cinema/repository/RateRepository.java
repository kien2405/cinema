package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<RateEntity, Integer> {
}
