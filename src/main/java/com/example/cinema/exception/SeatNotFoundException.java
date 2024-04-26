package com.example.ThucTapLTS.exception;

public class SeatNotFoundException extends RuntimeException{
    private String message;

    public SeatNotFoundException(String message) {
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