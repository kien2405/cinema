package com.example.cinema.controller;


import com.example.cinema.dto.request.AuthenticationRequest;
import com.example.cinema.dto.request.IntrospectRequest;
import com.example.cinema.dto.response.ApiResponse;
import com.example.cinema.dto.response.AuthenticationResponse;
import com.example.cinema.dto.response.IntrospectResponse;
import com.example.cinema.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/token")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request){
        var result = authenticationService.authenticate(request);
        ApiResponse<AuthenticationResponse> response = new ApiResponse<>();
        response.setData(result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/introspect")
    public ResponseEntity<?> authenticate(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        ApiResponse<IntrospectResponse> response = new ApiResponse<>();
        response.setData(result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
