package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "seat")
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number")
    private int number;

    @Column(name = "line")
    private String line;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;

    @ManyToOne
    @JoinColumn(name = "seat_status_id")
    private SeatStatusEntity seatStatusEntity;

    @ManyToOne
    @JoinColumn(name = "seat_type_id")
    private SeatTypeEntity seatTypeEntity;

    @OneToMany(mappedBy = "seatEntity")
    List<TicketEntity> ticketEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public RoomEntity getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(RoomEntity roomEntity) {
        this.roomEntity = roomEntity;
    }

    public SeatStatusEntity getSeatStatusEntity() {
        return seatStatusEntity;
    }

    public void setSeatStatusEntity(SeatStatusEntity seatStatusEntity) {
        this.seatStatusEntity = seatStatusEntity;
    }

    public SeatTypeEntity getSeatTypeEntity() {
        return seatTypeEntity;
    }

    public void setSeatTypeEntity(SeatTypeEntity seatTypeEntity) {
        this.seatTypeEntity = seatTypeEntity;
    }

    public List<TicketEntity> getTicketEntityList() {
        return ticketEntityList;
    }

    public void setTicketEntityList(List<TicketEntity> ticketEntityList) {
        this.ticketEntityList = ticketEntityList;
    }
}
