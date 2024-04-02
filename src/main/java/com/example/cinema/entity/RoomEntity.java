package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "Room")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Capacity")
    Integer capacity;

    @Column(name = "Type")
    Integer type;

    @Column(name = "Description")
    String description;

    @ManyToOne
    @JoinColumn(name = "CinemaId")
    CinemaEntity cinema;

    @Column(name = "Code")
    String code;

    @Column(name = "Name")
    String name;

    @Column(name = "IsActive")
    Boolean isActive;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    List<ScheduleEntity> schedules;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    List<SeatEntity> seats;
}
