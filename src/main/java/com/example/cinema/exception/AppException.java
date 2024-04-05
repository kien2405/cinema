package com.example.cinema.exception;

import com.example.cinema.enums.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AppException extends RuntimeException{
    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}