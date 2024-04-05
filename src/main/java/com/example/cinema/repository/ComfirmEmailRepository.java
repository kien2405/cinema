package com.example.cinema.repository;

import com.example.cinema.entity.ConfirmEmailEntity;
import com.example.cinema.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComfirmEmailRepository extends JpaRepository<ConfirmEmailEntity, Integer> {
    Optional<ConfirmEmailEntity> findByUserEmailAndConfirmCode(String email, String otp);
}
