package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "percent")
    private int percent;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "type")
    private String type;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "rank_customer_id")
    private RankCustomerEntity rankCustomerEntity;

    @OneToMany(mappedBy = "promotionEntity")
    List<BillEntity> billEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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

    public RankCustomerEntity getRankCustomerEntity() {
        return rankCustomerEntity;
    }

    public void setRankCustomerEntity(RankCustomerEntity rankCustomerEntity) {
        this.rankCustomerEntity = rankCustomerEntity;
    }

    public List<BillEntity> getBillEntityList() {
        return billEntityList;
    }

    public void setBillEntityList(List<BillEntity> billEntityList) {
        this.billEntityList = billEntityList;
    }
}
