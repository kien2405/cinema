package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.GeneralSettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralSettingRepository extends JpaRepository<GeneralSettingEntity, Integer> {
}
