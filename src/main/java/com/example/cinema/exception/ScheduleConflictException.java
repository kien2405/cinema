package com.example.ThucTapLTS.exception;

public class ScheduleConflictException extends RuntimeException{
    private String message;

    public ScheduleConflictException(String message) {
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