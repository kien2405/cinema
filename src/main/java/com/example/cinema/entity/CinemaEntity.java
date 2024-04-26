package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cinema")
public class CinemaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @Column(name = "name_of_cinema")
    private String nameOfCinema;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "cinemaEntity")
    List<RoomEntity> roomEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getNameOfCinema() {
        return nameOfCinema;
    }

    public void setNameOfCinema(String nameOfCinema) {
        this.nameOfCinema = nameOfCinema;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<RoomEntity> getRoomEntityList() {
        return roomEntityList;
    }

    public void setRoomEntityList(List<RoomEntity> roomEntityList) {
        this.roomEntityList = roomEntityList;
    }
}
