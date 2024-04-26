package com.example.ThucTapLTS.exception;

public class MovieNotFoundException extends RuntimeException{
    private String message;

    public MovieNotFoundException(String message) {
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