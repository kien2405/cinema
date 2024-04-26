package com.example.ThucTapLTS.exception;

public class MailNotFoundException extends RuntimeException{
    private String message;

    public MailNotFoundException(String message) {
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