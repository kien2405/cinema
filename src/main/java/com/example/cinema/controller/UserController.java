package com.example.cinema.controller;

import com.example.cinema.dto.request.UserChangePasswordRequest;
import com.example.cinema.dto.request.UserCreateRequest;
import com.example.cinema.dto.request.UserForgetPasswordRequest;
import com.example.cinema.dto.request.UserVerifyRequest;
import com.example.cinema.dto.response.ApiResponse;
import com.example.cinema.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserCreateRequest request){
        ApiResponse response = new ApiResponse<>();
        response.setData(userService.createRequest(request));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/verifyUser")
    public ResponseEntity<?> verifyUser(@RequestBody UserVerifyRequest request) {
        ApiResponse response = new ApiResponse<>();
        response.setData(userService.registerVerify(request));
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/forgetPassword")
    public ResponseEntity<?> forgetPassword(@RequestBody UserForgetPasswordRequest request) {
        ApiResponse response = new ApiResponse<>();
        userService.forgetPassword(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody UserChangePasswordRequest request) {
        ApiResponse response = new ApiResponse<>();
        userService.updatePassword(request);
        return ResponseEntity.ok(response);
    }
}
