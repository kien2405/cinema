package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Schedule")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Price")
    Double price;

    @Column(name = "StartAt")
    Date startAt;

    @Column(name = "EndAt")
    Date endAt;

    @Column(name = "Code")
    String code;

    @ManyToOne
    @JoinColumn(name = "MovieId")
    MovieEntity movie;

    @Column(name = "Name")
    String name;

    @ManyToOne
    @JoinColumn(name = "RoomId")
    RoomEntity room;

    @Column(name = "IsActive")
    Boolean isActive;

    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
    List<TicketEntity> tickets;
}
