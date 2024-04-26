package com.example.ThucTapLTS.mapper;

import com.example.ThucTapLTS.dto.BillTicketDTO;
import com.example.ThucTapLTS.entity.BillEntity;
import com.example.ThucTapLTS.entity.BillTicketEntity;
import com.example.ThucTapLTS.entity.RoomEntity;
import com.example.ThucTapLTS.entity.TicketEntity;
import com.example.ThucTapLTS.repository.BillRepository;
import com.example.ThucTapLTS.repository.RoomRepository;
import com.example.ThucTapLTS.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BillTicketMapper {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private RoomRepository roomRepository;

    public BillTicketDTO toDTO (BillTicketEntity billTicketEntity){
        BillTicketDTO billTicketDTO = new BillTicketDTO();
        billTicketDTO.setQuantity(billTicketEntity.getQuantity());
        billTicketDTO.setBillId(billTicketEntity.getBillEntity().getId());
        billTicketDTO.setTicketId(billTicketEntity.getTicketEntity().getId());
        return billTicketDTO;
    }

    public BillTicketEntity toEntity (BillTicketDTO billTicketDTO){
        BillTicketEntity billTicketEntity = new BillTicketEntity();
        billTicketEntity.setQuantity(billTicketDTO.getQuantity());
        try {
            Optional<BillEntity> billEntityOptional = billRepository.findById(billTicketDTO.getBillId());
            BillEntity billEntity = new BillEntity();
            if (billEntityOptional.isPresent()) {
                billEntity = billEntityOptional.get();
            }
            billTicketEntity.setBillEntity(billEntity);
        } catch (Exception ex) {
        }
        try {
            Optional<TicketEntity> ticketEntityOptional = ticketRepository.findById(billTicketDTO.getTicketId());
            TicketEntity ticketEntity = new TicketEntity();
            if (ticketEntityOptional.isPresent()) {
                ticketEntity = ticketEntityOptional.get();
            }
            billTicketEntity.setTicketEntity(ticketEntity);
        } catch (Exception ex) {

        }
        return billTicketEntity;
    }

    public List<BillTicketDTO> toDTOList (List<BillTicketEntity> billTicketEntityList){
        List<BillTicketDTO> billTicketDTOList = new ArrayList<>();
        for (BillTicketEntity data : billTicketEntityList) {
            BillTicketDTO billTicketDTO = new BillTicketDTO();
            billTicketDTO.setQuantity(data.getQuantity());
            billTicketDTO.setBillId(data.getBillEntity().getId());
            billTicketDTO.setTicketId(data.getTicketEntity().getId());
            billTicketDTOList.add(billTicketDTO);
        }
        return billTicketDTOList;
    }

    public List<BillTicketEntity> toEntityList (List<BillTicketDTO> billTicketDTOList){
        List<BillTicketEntity> billTicketEntityList = new ArrayList<>();
        for (BillTicketDTO data : billTicketDTOList) {
            BillTicketEntity billTicketEntity = new BillTicketEntity();
            billTicketEntity.setQuantity(data.getQuantity());
            try {
                Optional<BillEntity> billEntityOptional = billRepository.findById(data.getBillId());
                BillEntity billEntity = new BillEntity();
                if (billEntityOptional.isPresent()) {
                    billEntity = billEntityOptional.get();
                }
                billTicketEntity.setBillEntity(billEntity);
            } catch (Exception ex) {
            }
            try {
                Optional<TicketEntity> ticketEntityOptional = ticketRepository.findById(data.getTicketId());
                TicketEntity ticketEntity = new TicketEntity();
                if (ticketEntityOptional.isPresent()) {
                    ticketEntity = ticketEntityOptional.get();
                }
                billTicketEntity.setTicketEntity(ticketEntity);
            } catch (Exception ex) {

            }
            billTicketEntityList.add(billTicketEntity);
        }
        return billTicketEntityList;
    }
}
