package com.example.cinema.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "BillTicket")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillTicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "Quantity")
    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "BillId")
    BillEntity bill;

    @ManyToOne
    @JoinColumn(name = "TicketId")
    TicketEntity ticket;
}
