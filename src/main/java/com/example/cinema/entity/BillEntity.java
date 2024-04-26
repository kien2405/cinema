package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bill")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_money")
    private double totalMoney;

    @Column(name = "trading_code")
    private String tradingCode;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "name")
    private String name;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private PromotionEntity promotionEntity;

    @ManyToOne
    @JoinColumn(name = "bill_status_id")
    private BillStatusEntity billStatusEntity;

    @OneToMany(mappedBy = "billEntity")
    List<BillFoodEntity> billFoodEntityList;

    @OneToMany(mappedBy = "billEntity")
    List<BillTicketEntity> billTicketEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getTradingCode() {
        return tradingCode;
    }

    public void setTradingCode(String tradingCode) {
        this.tradingCode = tradingCode;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public PromotionEntity getPromotionEntity() {
        return promotionEntity;
    }

    public void setPromotionEntity(PromotionEntity promotionEntity) {
        this.promotionEntity = promotionEntity;
    }

    public BillStatusEntity getBillStatusEntity() {
        return billStatusEntity;
    }

    public void setBillStatusEntity(BillStatusEntity billStatusEntity) {
        this.billStatusEntity = billStatusEntity;
    }

    public List<BillFoodEntity> getBillFoodEntityList() {
        return billFoodEntityList;
    }

    public void setBillFoodEntityList(List<BillFoodEntity> billFoodEntityList) {
        this.billFoodEntityList = billFoodEntityList;
    }

    public List<BillTicketEntity> getBillTicketEntityList() {
        return billTicketEntityList;
    }

    public void setBillTicketEntityList(List<BillTicketEntity> billTicketEntityList) {
        this.billTicketEntityList = billTicketEntityList;
    }


}
