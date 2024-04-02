package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "Cinema")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CinemaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Address")
    String address;

    @Column(name = "Description")
    String description;

    @Column(name = "Code")
    String code;

    @Column(name = "NameOfCinema")
    String nameOfCinema;

    @Column(name = "IsActive")
    Boolean isActive;

    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
    List<RoomEntity> rooms;

}
