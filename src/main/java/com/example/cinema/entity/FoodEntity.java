package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "food")
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "name_of_food")
    private String nameOfFood;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "foodEntity")
    List<BillFoodEntity> billFoodEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameOfFood() {
        return nameOfFood;
    }

    public void setNameOfFood(String nameOfFood) {
        this.nameOfFood = nameOfFood;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<BillFoodEntity> getBillFoodEntityList() {
        return billFoodEntityList;
    }

    public void setBillFoodEntityList(List<BillFoodEntity> billFoodEntityList) {
        this.billFoodEntityList = billFoodEntityList;
    }
}
