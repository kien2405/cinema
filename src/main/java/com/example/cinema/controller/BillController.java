package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.dto.BillDTO;
import com.example.ThucTapLTS.dto.BillFoodDTO;
import com.example.ThucTapLTS.dto.FoodDTO;
import com.example.ThucTapLTS.entity.FoodEntity;
import com.example.ThucTapLTS.mapper.BillMapper;
import com.example.ThucTapLTS.mapper.FoodMapper;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.service.imp.BillServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillServiceImp billServiceImp;

    @Autowired
    private BillMapper billMapper;

    @PostMapping("/crud/add")
    public ResponseEntity<?> addBill(@RequestBody BillDTO billDTO) {
        billServiceImp.addBill(billMapper.toEntity(billDTO));
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Thêm bill thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
