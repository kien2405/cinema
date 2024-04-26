package com.example.ThucTapLTS.exception;

public class CinemaNotFoundException extends RuntimeException{
    private String message;

    public CinemaNotFoundException(String message) {
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
