package com.example.cinema.controller;

import com.example.cinema.dto.request.UserCreateRequest;
import com.example.cinema.dto.response.ApiResponse;
import com.example.cinema.service.MailService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MailController {
    @Autowired
    MailService mailService;

    @PostMapping("/sendMail")
    public ResponseEntity<?> sendMail(@RequestParam String email){
        ApiResponse response = new ApiResponse<>();
        response.setData(mailService.mailRequest(email));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
