package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "rank_customer")
public class RankCustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "point")
    private int point;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "rankCustomerEntity")
    List<PromotionEntity> promotionEntityList;

    @OneToMany(mappedBy = "rankCustomerEntity")
    List<UserEntity> userEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<PromotionEntity> getPromotionEntityList() {
        return promotionEntityList;
    }

    public void setPromotionEntityList(List<PromotionEntity> promotionEntityList) {
        this.promotionEntityList = promotionEntityList;
    }

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }
}
