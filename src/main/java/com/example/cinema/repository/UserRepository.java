package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.RoleEntity;
import com.example.ThucTapLTS.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);

    @Query("SELECT u.roleEntity FROM UserEntity u WHERE u.email = :email")
    List<RoleEntity> findRoleByEmail(String email);
}
