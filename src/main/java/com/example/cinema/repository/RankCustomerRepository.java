package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.RankCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankCustomerRepository extends JpaRepository<RankCustomerEntity, Integer> {
}
