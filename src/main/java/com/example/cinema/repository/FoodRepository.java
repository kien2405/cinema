package com.example.ThucTapLTS.repository;

import com.example.ThucTapLTS.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer> {
    @Query("SELECT f, SUM(bf.quantity) AS SoLuongBan " +
            "FROM BillEntity b " +
            "JOIN BillFoodEntity bf ON b.id = bf.billEntity.id " +
            "JOIN FoodEntity f ON f.id = bf.foodEntity.id " +
            "WHERE b.createTime >= :sevenDaysAgo AND b.billStatusEntity.id = 1 " +
            "GROUP BY f " +
            "ORDER BY SoLuongBan DESC ")
    List<Object[]> foodSalesLast7Days(@Param("sevenDaysAgo") LocalDateTime sevenDaysAgo);
}
