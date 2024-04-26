package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "price_ticket")
    private double priceTicket;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private ScheduleEntity scheduleEntity;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private SeatEntity seatEntity;

    @OneToMany(mappedBy = "ticketEntity")
    List<BillTicketEntity> billTicketEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ScheduleEntity getScheduleEntity() {
        return scheduleEntity;
    }

    public void setScheduleEntity(ScheduleEntity scheduleEntity) {
        this.scheduleEntity = scheduleEntity;
    }

    public SeatEntity getSeatEntity() {
        return seatEntity;
    }

    public void setSeatEntity(SeatEntity seatEntity) {
        this.seatEntity = seatEntity;
    }

    public List<BillTicketEntity> getBillTicketEntityList() {
        return billTicketEntityList;
    }

    public void setBillTicketEntityList(List<BillTicketEntity> billTicketEntityList) {
        this.billTicketEntityList = billTicketEntityList;
    }
}
