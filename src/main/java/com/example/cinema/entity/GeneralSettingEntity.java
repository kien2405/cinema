package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "general_setting")
public class GeneralSettingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "break_time")
    private LocalDateTime breakTime;

    @Column(name = "business_hours")
    private int businessHours;

    @Column(name = "close_time")
    private LocalDateTime closeTime;

    @Column(name = "fixed_ticket_price")
    private double fixedTicketPrice;

    @Column(name = "percent_day")
    private int percentDay;

    @Column(name = "percent_weekend")
    private int percentWeekend;

    @Column(name = "time_begin_to_change")
    private LocalDateTime timeBeginToChange;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(LocalDateTime breakTime) {
        this.breakTime = breakTime;
    }

    public int getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(int businessHours) {
        this.businessHours = businessHours;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }

    public double getFixedTicketPrice() {
        return fixedTicketPrice;
    }

    public void setFixedTicketPrice(double fixedTicketPrice) {
        this.fixedTicketPrice = fixedTicketPrice;
    }

    public int getPercentDay() {
        return percentDay;
    }

    public void setPercentDay(int percentDay) {
        this.percentDay = percentDay;
    }

    public int getPercentWeekend() {
        return percentWeekend;
    }

    public void setPercentWeekend(int percentWeekend) {
        this.percentWeekend = percentWeekend;
    }

    public LocalDateTime getTimeBeginToChange() {
        return timeBeginToChange;
    }

    public void setTimeBeginToChange(LocalDateTime timeBeginToChange) {
        this.timeBeginToChange = timeBeginToChange;
    }
}
