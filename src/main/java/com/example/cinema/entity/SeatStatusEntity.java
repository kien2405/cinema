package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "seat_status")
public class SeatStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "name_status")
    private String nameStatus;

    @OneToMany(mappedBy = "seatStatusEntity")
    List<SeatEntity> seatEntityList;

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

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    public List<SeatEntity> getSeatEntityList() {
        return seatEntityList;
    }

    public void setSeatEntityList(List<SeatEntity> seatEntityList) {
        this.seatEntityList = seatEntityList;
    }
}
