package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "type")
    private int type;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private CinemaEntity cinemaEntity;

    @OneToMany(mappedBy = "roomEntity")
    List<ScheduleEntity> scheduleEntityList;

    @OneToMany(mappedBy = "roomEntity")
    List<SeatEntity> seatEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public CinemaEntity getCinemaEntity() {
        return cinemaEntity;
    }

    public void setCinemaEntity(CinemaEntity cinemaEntity) {
        this.cinemaEntity = cinemaEntity;
    }

    public List<ScheduleEntity> getScheduleEntityList() {
        return scheduleEntityList;
    }

    public void setScheduleEntityList(List<ScheduleEntity> scheduleEntityList) {
        this.scheduleEntityList = scheduleEntityList;
    }

    public List<SeatEntity> getSeatEntityList() {
        return seatEntityList;
    }

    public void setSeatEntityList(List<SeatEntity> seatEntityList) {
        this.seatEntityList = seatEntityList;
    }
}
