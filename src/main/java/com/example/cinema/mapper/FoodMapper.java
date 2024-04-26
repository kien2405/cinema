package com.example.ThucTapLTS.mapper;

import com.example.ThucTapLTS.dto.FoodDTO;
import com.example.ThucTapLTS.entity.FoodEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {
    @Autowired
    private BillFoodMapper billFoodMapper;

    public FoodDTO toDTO (FoodEntity foodEntity){
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setDescription(foodEntity.getDescription());
        foodDTO.setImage(foodEntity.getImage());
        foodDTO.setNameOfFood(foodEntity.getNameOfFood());
        foodDTO.setPrice(foodEntity.getPrice());
        foodDTO.setActive(foodEntity.isActive());
        try {
            foodDTO.setBillFoodDTOList(billFoodMapper.toDTOList(foodEntity.getBillFoodEntityList()));
        } catch (Exception e) {
            
        }
        return foodDTO;
    }

    public FoodEntity toEntity (FoodDTO foodDTO){
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setDescription(foodDTO.getDescription());
        foodEntity.setImage(foodDTO.getImage());
        foodEntity.setNameOfFood(foodDTO.getNameOfFood());
        foodEntity.setPrice(foodDTO.getPrice());
        foodEntity.setActive(foodDTO.isActive());
        try {
            foodEntity.setBillFoodEntityList(billFoodMapper.toEntityList(foodDTO.getBillFoodDTOList()));
        } catch (Exception e) {

        }
        return foodEntity;
    }
}
