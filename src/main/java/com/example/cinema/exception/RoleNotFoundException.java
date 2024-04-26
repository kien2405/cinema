package com.example.ThucTapLTS.exception;

public class RoleNotFoundException extends RuntimeException{
    private String message;

    public RoleNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}