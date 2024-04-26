package com.example.ThucTapLTS.service;

import com.example.ThucTapLTS.entity.BillTicketEntity;
import com.example.ThucTapLTS.entity.TicketEntity;
import com.example.ThucTapLTS.repository.BillTicketRepository;
import com.example.ThucTapLTS.repository.TicketRepository;
import com.example.ThucTapLTS.service.imp.TicketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements TicketServiceImp {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private BillTicketRepository billTicketRepository;

    @Override
    public void addTicket(List<TicketEntity> ticketEntityList) {
        ticketRepository.saveAll(ticketEntityList);
    }
}
