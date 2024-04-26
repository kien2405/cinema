package com.example.ThucTapLTS.service.imp;

import com.example.ThucTapLTS.payload.request.ActiveUserRequest;
import com.example.ThucTapLTS.payload.request.ChangePasswordRequest;
import com.example.ThucTapLTS.payload.request.ForgetPasswordRequest;
import com.example.ThucTapLTS.payload.request.SignupRequest;

public interface UserServiceImp {
    boolean addUser(SignupRequest request);

    boolean activeUser(ActiveUserRequest activeUserRequest);

    void changePassword(ChangePasswordRequest changePasswordRequest);

    void forgetPassword(ForgetPasswordRequest forgetPasswordRequest);

    void changeRole(int idUser, int idRole);
}
