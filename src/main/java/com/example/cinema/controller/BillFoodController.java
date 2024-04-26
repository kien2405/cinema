package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.dto.BillFoodDTO;
import com.example.ThucTapLTS.dto.CinemaDTO;
import com.example.ThucTapLTS.entity.BillFoodEntity;
import com.example.ThucTapLTS.mapper.BillFoodMapper;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.repository.BillFoodRepository;
import com.example.ThucTapLTS.service.imp.BillFoodServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/billFood")
public class BillFoodController {

}
