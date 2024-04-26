package com.example.ThucTapLTS.dto;

import java.util.List;

public class CinemaDTO {
    private String address;

    private String description;

    private String code;

    private boolean isActive;

    private String nameOfCinema;

    private List<RoomDTO> roomDTOList;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getNameOfCinema() {
        return nameOfCinema;
    }

    public void setNameOfCinema(String nameOfCinema) {
        this.nameOfCinema = nameOfCinema;
    }

    public List<RoomDTO> getRoomDTOList() {
        return roomDTOList;
    }

    public void setRoomDTOList(List<RoomDTO> roomDTOList) {
        this.roomDTOList = roomDTOList;
    }
}
