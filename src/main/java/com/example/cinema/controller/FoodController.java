package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.dto.FoodDTO;
import com.example.ThucTapLTS.dto.SeatDTO;
import com.example.ThucTapLTS.entity.FoodEntity;
import com.example.ThucTapLTS.entity.SeatEntity;
import com.example.ThucTapLTS.mapper.FoodMapper;
import com.example.ThucTapLTS.mapper.SeatMapper;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.service.imp.FoodServiceImp;
import com.example.ThucTapLTS.service.imp.SeatServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodServiceImp foodServiceImp;

    @Autowired
    private FoodMapper foodMapper;

    @PostMapping("/add")
    public ResponseEntity<?> addSeat(@RequestBody FoodDTO foodDTO) {
        foodServiceImp.addFood(foodMapper.toEntity(foodDTO));
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Thêm món ăn thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editFood(@RequestBody FoodDTO foodDTO,
                                      @PathVariable int id) {
        FoodEntity foodEntity = foodMapper.toEntity(foodDTO);
        foodEntity.setId(id);
        foodServiceImp.editFood(foodEntity);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Sửa món ăn thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable int id) {
        foodServiceImp.deleteFood(id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Xóa món ăn thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/foodSalesLast7Days")
    public ResponseEntity<?> getFoodSalesLast7Days() {
        List<Object[]> objects = foodServiceImp.foodSalesLast7Days();
        List<Map<String, Object>> result = new ArrayList<>();
        for (Object[] obj : objects) {
            FoodEntity foodEntity = (FoodEntity) obj[0];
            Long quantity = (Long) obj[1];
            FoodDTO foodDTO = foodMapper.toDTO(foodEntity);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("FoodDTO", foodDTO);
            resultMap.put("soLuongBan", quantity);
            result.add(resultMap);
        }
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
