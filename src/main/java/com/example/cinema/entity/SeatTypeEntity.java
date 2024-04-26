package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "seat_type")
public class SeatTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_type")
    private String nameType;

    @OneToMany(mappedBy = "seatTypeEntity")
    List<SeatEntity> seatEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public List<SeatEntity> getSeatEntityList() {
        return seatEntityList;
    }

    public void setSeatEntityList(List<SeatEntity> seatEntityList) {
        this.seatEntityList = seatEntityList;
    }
}
