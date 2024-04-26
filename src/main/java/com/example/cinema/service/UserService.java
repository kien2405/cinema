package com.example.ThucTapLTS.service;

import com.example.ThucTapLTS.entity.ConfirmEmailEntity;
import com.example.ThucTapLTS.entity.RoleEntity;
import com.example.ThucTapLTS.entity.UserEntity;
import com.example.ThucTapLTS.exception.CustomException;
import com.example.ThucTapLTS.exception.UserNotFoundException;
import com.example.ThucTapLTS.payload.request.ActiveUserRequest;
import com.example.ThucTapLTS.payload.request.ChangePasswordRequest;
import com.example.ThucTapLTS.payload.request.ForgetPasswordRequest;
import com.example.ThucTapLTS.payload.request.SignupRequest;
import com.example.ThucTapLTS.repository.ConfirmEmailRepository;
import com.example.ThucTapLTS.repository.RoleRepository;
import com.example.ThucTapLTS.repository.UserRepository;
import com.example.ThucTapLTS.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ConfirmEmailRepository confirmEmailRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean addUser(SignupRequest request) {
        boolean isSuccess = false;
        try{
            if (userRepository.findByEmail(request.getEmail()) != null) {
                throw new CustomException("có email trùng với user cũ");
            }
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());
            user.setName(request.getName());
            user.setPhoneNumber(request.getPhoneNumber());
            userRepository.save(user);
            isSuccess = true;
        } catch (Exception e) {
            throw new CustomException("Lỗi thêm User " + e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public boolean activeUser(ActiveUserRequest activeUserRequest) {
        boolean isSuccess = false;
        try{
            UserEntity userEntity = userRepository.findByEmail(activeUserRequest.getEmail());
            Optional<ConfirmEmailEntity> confirmEmailEntityOptional = confirmEmailRepository.findByUserEntityAndIsConfirm(userEntity, true);
            ConfirmEmailEntity confirmEmailEntity = new ConfirmEmailEntity();
            if (confirmEmailEntityOptional.isPresent()) {
                confirmEmailEntity = confirmEmailEntityOptional.get();
            }
            if (confirmEmailEntity.getConfirmCode().equals(activeUserRequest.getCode())) {
                userEntity.setActive(true);
            } else {
                userEntity.setActive(false);
            }
            userRepository.save(userEntity);
            isSuccess = true;
        } catch (Exception e) {
            throw new CustomException("Lỗi lấy ConfirmEmail: " + e.getMessage());
        }
        return isSuccess;
    }

    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        // Lấy thông tin người dùng hiện tại từ SecurityContextHolder
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Lấy thông tin người dùng từ cơ sở dữ liệu
        UserEntity userEntity = userRepository.findByEmail(username);

        // Kiểm tra xác thực mật khẩu cũ
        if (!passwordEncoder.matches(changePasswordRequest.getOldPassword(), userEntity.getPassword())) {
            throw new RuntimeException("Mật khẩu cũ không đúng");
        }

        // Mã hóa mật khẩu mới
        String encodedPassword = passwordEncoder.encode(changePasswordRequest.getNewPassword());

        // Cập nhật mật khẩu mới vào cơ sở dữ liệu
        userEntity.setPassword(encodedPassword);
        userRepository.save(userEntity);
    }

    @Override
    public void forgetPassword(ForgetPasswordRequest forgetPasswordRequest) {
        UserEntity userEntity = userRepository.findByEmail(forgetPasswordRequest.getEmail());
        Optional<ConfirmEmailEntity> confirmEmailEntityOptional = confirmEmailRepository.findByUserEntityAndIsConfirm(userEntity, true);
        ConfirmEmailEntity confirmEmailEntity = new ConfirmEmailEntity();
        if (confirmEmailEntityOptional.isPresent()) {
            confirmEmailEntity = confirmEmailEntityOptional.get();
        }
        if(confirmEmailEntity.getConfirmCode().equals(forgetPasswordRequest.getCode())) {
            String encodedPassword = passwordEncoder.encode(forgetPasswordRequest.getNewPassword());
            userEntity.setPassword(encodedPassword);
            userRepository.save(userEntity);
        } else {
            throw new CustomException("Code nhập vào không đúng");
        }
    }

    @Override
    public void changeRole(int idUser, int idRole) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(idUser);
        UserEntity userEntity = new UserEntity();
        if (userEntityOptional.isPresent()) {
            userEntity = userEntityOptional.get();
        } else {
            throw new UserNotFoundException("User not found");
        }
        Optional<RoleEntity> roleEntityOptional = roleRepository.findById(idRole);
        RoleEntity roleEntity = new RoleEntity();
        if (roleEntityOptional.isPresent()) {
            roleEntity = roleEntityOptional.get();
        } else {
            throw new UserNotFoundException("Role not found");
        }
        userEntity.setRoleEntity(roleEntity);
        userRepository.save(userEntity);
    }
}
