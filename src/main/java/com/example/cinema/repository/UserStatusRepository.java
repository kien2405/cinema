package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.UserStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatusEntity, Integer> {
}
