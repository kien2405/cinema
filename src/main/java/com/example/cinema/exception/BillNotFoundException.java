package com.example.ThucTapLTS.exception;

public class BillNotFoundException extends RuntimeException{
    private String message;

    public BillNotFoundException(String message) {
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