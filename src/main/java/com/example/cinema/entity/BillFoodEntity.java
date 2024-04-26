package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bill_food")
public class BillFoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private BillEntity billEntity;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private FoodEntity foodEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BillEntity getBillEntity() {
        return billEntity;
    }

    public void setBillEntity(BillEntity billEntity) {
        this.billEntity = billEntity;
    }

    public FoodEntity getFoodEntity() {
        return foodEntity;
    }

    public void setFoodEntity(FoodEntity foodEntity) {
        this.foodEntity = foodEntity;
    }
}
