package com.example.ThucTapLTS.service;

import com.example.ThucTapLTS.entity.CinemaEntity;
import com.example.ThucTapLTS.entity.FoodEntity;
import com.example.ThucTapLTS.entity.RoomEntity;
import com.example.ThucTapLTS.exception.CinemaNotFoundException;
import com.example.ThucTapLTS.exception.CustomException;
import com.example.ThucTapLTS.exception.FoodNotFoundException;
import com.example.ThucTapLTS.repository.FoodRepository;
import com.example.ThucTapLTS.service.imp.FoodServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements FoodServiceImp {
    @Autowired
    private FoodRepository foodRepository;

    @Override
    public void addFood(FoodEntity foodEntity) {
        foodRepository.save(foodEntity);
    }

    @Override
    public void editFood(FoodEntity foodEntity) {
        try {
            Optional<FoodEntity> foodEntityOptional = foodRepository.findById(foodEntity.getId());
        } catch (Exception e) {
            throw new FoodNotFoundException("Food not found");
        }
        addFood(foodEntity);
    }

    @Override
    public void deleteFood(int id) {
        try {
            Optional<FoodEntity> foodEntityOptional = foodRepository.findById(id);
            FoodEntity foodEntity = new FoodEntity();
            if (foodEntityOptional.isPresent()) {
                foodEntity = foodEntityOptional.get();
                foodEntity.setActive(false);
                foodRepository.save(foodEntity);
            }
        } catch (Exception ex) {
            throw new FoodNotFoundException("Food not found");
        }
    }

    public List<Object[]> foodSalesLast7Days() {
        List<Object[]> objects = foodRepository.foodSalesLast7Days(LocalDateTime.now().minusDays(7));
        for (Object[] obj : objects) {
            FoodEntity foodEntity = (FoodEntity) obj[0];
            foodEntity.setBillFoodEntityList(null);
        }
        return objects;
    }
}
