package com.example.cinema.repository;

import com.example.cinema.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<UserEntity> findByUsernameAndIsActive(String username, Boolean active);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByEmailAndIsActive(String email, Boolean active);
    Optional<UserEntity> findByUsername(String username);





}
