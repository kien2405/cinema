package com.example.ThucTapLTS.dto;

import java.util.List;

public class TicketDTO {
    private String code;

    private boolean isActive;

    private double priceTicket;

    private int scheduleId;

    private int seatId;

    private List<BillTicketDTO> billTicketDTOList;

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

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public List<BillTicketDTO> getBillTicketDTOList() {
        return billTicketDTOList;
    }

    public void setBillTicketDTOList(List<BillTicketDTO> billTicketDTOList) {
        this.billTicketDTOList = billTicketDTOList;
    }
}
