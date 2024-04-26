package com.example.ThucTapLTS.exception;

public class RoomNotFoundException extends RuntimeException{
    private String message;

    public RoomNotFoundException(String message) {
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