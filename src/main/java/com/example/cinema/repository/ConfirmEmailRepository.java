package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.ConfirmEmailEntity;
import com.example.ThucTapLTS.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ConfirmEmailRepository extends JpaRepository<ConfirmEmailEntity, Integer> {
    Optional<ConfirmEmailEntity> findByUserEntityAndIsConfirm(UserEntity userEntity, boolean isSuccess);
}
