package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "Seat")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Number")
    Integer number;

    @ManyToOne
    @JoinColumn(name = "SeatStatusId")
    SeatStatusEntity seatStatus;

    @ManyToOne
    @JoinColumn(name = "RoomId")
    RoomEntity room;

    @Column(name = "IsActive")
    Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "SeatTypeId")
    SeatTypeEntity seatType;

    @OneToMany(mappedBy = "seat", fetch = FetchType.LAZY)
    List<TicketEntity> tickets;
}
