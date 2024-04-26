package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.RefreshTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshTokenEntity, Integer> {
    @Query(value = "SELECT token " +
            "FROM refresh_token " +
            "WHERE refresh_token.user_id = 1 " +
            "ORDER BY refresh_token.id DESC " +
            "LIMIT 1", nativeQuery = true)
    String findLatestTokenByUserId(@Param("userId") Integer userId);
}
