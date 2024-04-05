package com.example.cinema.service.imp;


import com.example.cinema.dto.request.UserChangePasswordRequest;
import com.example.cinema.dto.request.UserCreateRequest;

import com.example.cinema.dto.request.UserForgetPasswordRequest;
import com.example.cinema.dto.request.UserVerifyRequest;
import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.entity.ConfirmEmailEntity;
import com.example.cinema.entity.RoleEntity;
import com.example.cinema.entity.UserEntity;
import com.example.cinema.enums.ErrorCode;
import com.example.cinema.enums.Role;
import com.example.cinema.exception.AppException;
import com.example.cinema.mapper.UserMapper;
import com.example.cinema.repository.ComfirmEmailRepository;
import com.example.cinema.repository.RoleRepository;
import com.example.cinema.repository.UserRepository;

import com.example.cinema.service.UserService;
import com.example.cinema.service.utils.Const;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ComfirmEmailRepository comfirmEmailRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;


    @Override
    public UserResponse createRequest(UserCreateRequest request) {

        if (userRepository.existsByUsername(request.getUsername()) ||
                userRepository.existsByEmail(request.getEmail())) {
            throw new AppException(ErrorCode.USER_EXITSTED);

        }

        UserEntity user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(roleRepository.findByCode("USER"));

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public String registerVerify(UserVerifyRequest request) {
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.WRONG_EMAIL));

        ConfirmEmailEntity verify = comfirmEmailRepository
                .findByUserEmailAndConfirmCode(request.getEmail(), request.getOtp())
                .orElseThrow(() -> new AppException(ErrorCode.INVALID_OTP_CODE));

        Date expirationTime = verify.getExpiredTime();
        if (expirationTime.after(new Date())) {
            user.setIsActive(true);
            userRepository.save(user);
            verify.setIsConfirm(true);
            comfirmEmailRepository.save(verify);
            return Const.SUCCESS_REGISTER.CLIENT_REGISTER;
        } else {
            throw new AppException(ErrorCode.OTP_TIME_OUT);
        }

    }

    @Override
    public void forgetPassword(UserForgetPasswordRequest request) {
        UserEntity user = userRepository.findByEmailAndIsActive(request.getEmail(),true)
                .orElseThrow(() -> new AppException(ErrorCode.WRONG_EMAIL));

        ConfirmEmailEntity verify = comfirmEmailRepository
                .findByUserEmailAndConfirmCode(request.getEmail(), request.getOtp())
                .orElseThrow(() -> new AppException(ErrorCode.INVALID_OTP_CODE));

        Date expirationTime = verify.getExpiredTime();
        if (expirationTime.after(new Date())) {
            user.setPassword(passwordEncoder.encode(request.getNewPassword()));
            userRepository.save(user);
            verify.setIsConfirm(true);
            comfirmEmailRepository.save(verify);

        } else {
            throw new AppException(ErrorCode.OTP_TIME_OUT);
        }
    }
    @Override
    public void updatePassword(UserChangePasswordRequest request) {
        var context = SecurityContextHolder.getContext();
        String name = context.getAuthentication().getName();

        UserEntity user = userRepository.findByUsername(name).orElseThrow(
                ()-> new AppException(ErrorCode.USER_NOT_EXISTED));

        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new AppException(ErrorCode.WRONG_PASSWORD);
        }

        String newPassword = passwordEncoder.encode(request.getNewPassword());

        user.setPassword(newPassword);
        userRepository.save(user);
    }


}
