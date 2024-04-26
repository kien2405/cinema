package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<BannerEntity, Integer> {
}
