package com.example.cinema.service;

import com.example.cinema.dto.request.UserChangePasswordRequest;
import com.example.cinema.dto.request.UserCreateRequest;
import com.example.cinema.dto.request.UserForgetPasswordRequest;
import com.example.cinema.dto.request.UserVerifyRequest;
import com.example.cinema.dto.response.UserResponse;

public interface UserService {
    UserResponse createRequest(UserCreateRequest request);
    String registerVerify(UserVerifyRequest request);
    void forgetPassword(UserForgetPasswordRequest request);
    void updatePassword(UserChangePasswordRequest request);
}
