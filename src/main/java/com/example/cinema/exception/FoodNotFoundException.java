package com.example.ThucTapLTS.exception;

public class FoodNotFoundException extends RuntimeException{
    private String message;

    public FoodNotFoundException(String message) {
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