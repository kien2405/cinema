package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.exception.CustomException;
import com.example.ThucTapLTS.helper.JwtHelper;
import com.example.ThucTapLTS.payload.request.SignupRequest;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.service.imp.MailServiceImp;
import com.example.ThucTapLTS.service.imp.UserServiceImp;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtHelper jwtHelper;

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private MailServiceImp mailServiceImp;


    /**
     * statusCode : 200
     * message : ""
     * data : kiểu gì cũng được
     */
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> signin(
            @RequestParam String email,
            @RequestParam String password
    ) {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String strKey = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(strKey);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);
        System.out.println(token);
        authenticationManager.authenticate(token);
        //  Nếu chứng thực thành công sẽ chạy code tiếp theo còn nếu thất bại thì sẽ văng lỗi chưa chứng thực
        String jwt = jwtHelper.generateToken(email);
        jwtHelper.refreshToken();
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(jwt);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> signup(@RequestBody SignupRequest request, BindingResult result) {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String strKey = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println(strKey);
        List<FieldError> list = result.getFieldErrors();
        for (FieldError data : list) {
            throw new CustomException(data.getDefaultMessage());
        }

        boolean isSuccess = userServiceImp.addUser(request);

        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(isSuccess);
        mailServiceImp.create(request.getEmail());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
