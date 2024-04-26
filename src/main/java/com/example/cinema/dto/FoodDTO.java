package com.example.ThucTapLTS.dto;

import com.example.ThucTapLTS.mapper.BillFoodMapper;

import java.util.List;

public class FoodDTO {
    private String description;

    private String image;

    private String nameOfFood;

    private double price;

    private boolean isActive;

    private List<BillFoodDTO> billFoodDTOList;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<BillFoodDTO> getBillFoodDTOList() {
        return billFoodDTOList;
    }

    public void setBillFoodDTOList(List<BillFoodDTO> billFoodDTOList) {
        this.billFoodDTOList = billFoodDTOList;
    }
}
