package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.BillStatusEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillStatusRepository extends JpaRepository<BillStatusEntity, Integer> {
}
