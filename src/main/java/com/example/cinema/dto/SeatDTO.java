package com.example.ThucTapLTS.dto;

import java.util.List;

public class SeatDTO {
    private boolean isActive;

    private String line;

    private int number;

    private int roomId;

    private int seatStatusId;

    private int seatTypeId;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getSeatStatusId() {
        return seatStatusId;
    }

    public void setSeatStatusId(int seatStatusId) {
        this.seatStatusId = seatStatusId;
    }

    public int getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(int seatTypeId) {
        this.seatTypeId = seatTypeId;
    }
}
