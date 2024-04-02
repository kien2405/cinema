package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "Ticket")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Code")
    String code;

    @ManyToOne
    @JoinColumn(name = "ScheduleId")
    ScheduleEntity schedule;

    @ManyToOne
    @JoinColumn(name = "SeatId")
    SeatEntity seat;

    @Column(name = "PriceTicket")
    Double priceTicket;

    @Column(name = "IsActive")
    Boolean isActive;

    @OneToMany(mappedBy = "ticket", fetch = FetchType.LAZY)
    List<BillTicketEntity> billTickets;

}
