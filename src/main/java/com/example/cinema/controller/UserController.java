package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.payload.request.ActiveUserRequest;
import com.example.ThucTapLTS.payload.request.ChangePasswordRequest;
import com.example.ThucTapLTS.payload.request.ForgetPasswordRequest;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServiceImp userServiceImp;

    @PostMapping("/activeUser")
    public ResponseEntity<?> activeUser(@RequestBody ActiveUserRequest activeUserRequest) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(userServiceImp.activeUser(activeUserRequest));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        userServiceImp.changePassword(changePasswordRequest);
        response.setMessage("Đổi mật khẩu thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/forgetPassword")
    public ResponseEntity<?> forgetPassword(@RequestBody ForgetPasswordRequest forgetPasswordRequest) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        userServiceImp.forgetPassword(forgetPasswordRequest);
        response.setMessage("Đổi mật khẩu thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/changeRole")
    public ResponseEntity<?> changeRole(@RequestParam int idUser,
                                        @RequestParam int idRole) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        userServiceImp.changeRole(idUser, idRole);
        response.setMessage("Đổi quyền thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
