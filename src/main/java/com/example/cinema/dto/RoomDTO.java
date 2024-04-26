package com.example.ThucTapLTS.dto;

import java.util.List;

public class RoomDTO {
    private int capacity;

    private String code;

    private String description;

    private boolean isActive;

    private String name;

    private int type;

    private int cinemaId;

    private List<SeatDTO> seatDTOList;

    private List<ScheduleDTO> scheduleDTOList;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public List<SeatDTO> getSeatDTOList() {
        return seatDTOList;
    }

    public void setSeatDTOList(List<SeatDTO> seatDTOList) {
        this.seatDTOList = seatDTOList;
    }

    public List<ScheduleDTO> getScheduleDTOList() {
        return scheduleDTOList;
    }

    public void setScheduleDTOList(List<ScheduleDTO> scheduleDTOList) {
        this.scheduleDTOList = scheduleDTOList;
    }
}
