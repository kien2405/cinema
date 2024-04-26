package com.example.ThucTapLTS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bill_ticket")
public class BillTicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private BillEntity billEntity;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticketEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BillEntity getBillEntity() {
        return billEntity;
    }

    public void setBillEntity(BillEntity billEntity) {
        this.billEntity = billEntity;
    }

    public TicketEntity getTicketEntity() {
        return ticketEntity;
    }

    public void setTicketEntity(TicketEntity ticketEntity) {
        this.ticketEntity = ticketEntity;
    }
}
