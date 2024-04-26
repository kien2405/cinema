package com.example.ThucTapLTS.mapper;

import com.example.ThucTapLTS.dto.BillFoodDTO;
import com.example.ThucTapLTS.dto.BillTicketDTO;
import com.example.ThucTapLTS.dto.TicketDTO;
import com.example.ThucTapLTS.entity.*;
import com.example.ThucTapLTS.repository.ScheduleRepository;
import com.example.ThucTapLTS.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TicketMapper {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private BillTicketMapper billTicketMapper;

    public TicketDTO toDTO (TicketEntity ticketEntity){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setCode(ticketEntity.getCode());
        ticketDTO.setPriceTicket(ticketEntity.getPriceTicket());
        ticketDTO.setActive(ticketEntity.isActive());
        ticketDTO.setScheduleId(ticketEntity.getScheduleEntity().getId());
        ticketDTO.setSeatId(ticketEntity.getSeatEntity().getId());
        ticketDTO.setBillTicketDTOList(billTicketMapper.toDTOList(ticketEntity.getBillTicketEntityList()));
        return ticketDTO;
    }

    public TicketEntity toEntity (TicketDTO ticketDTO){
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setCode(ticketDTO.getCode());
        ticketEntity.setPriceTicket(ticketDTO.getPriceTicket());
        ticketEntity.setActive(ticketDTO.isActive());
        try {
            Optional<ScheduleEntity> scheduleEntityOptional = scheduleRepository.findById(ticketDTO.getScheduleId());
            ScheduleEntity scheduleEntity = new ScheduleEntity();
            if (scheduleEntityOptional.isPresent()) {
                scheduleEntity = scheduleEntityOptional.get();
            }
            ticketEntity.setScheduleEntity(scheduleEntity);
        } catch (Exception ex) {

        }
        try {
            Optional<SeatEntity> seatEntityOptional = seatRepository.findById(ticketDTO.getSeatId());
            SeatEntity seatEntity = new SeatEntity();
            if (seatEntityOptional.isPresent()) {
                seatEntity = seatEntityOptional.get();
            }
            ticketEntity.setSeatEntity(seatEntity);
        } catch (Exception ex) {

        }
        ticketEntity.setBillTicketEntityList(billTicketMapper.toEntityList(ticketDTO.getBillTicketDTOList()));
        return ticketEntity;
    }

    public List<TicketDTO> toDTOList (List<TicketEntity> ticketEntityList){
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for (TicketEntity data : ticketEntityList) {
            TicketDTO ticketDTO = new TicketDTO();
            ticketDTO.setCode(data.getCode());
            ticketDTO.setPriceTicket(data.getPriceTicket());
            ticketDTO.setActive(data.isActive());
            ticketDTO.setScheduleId(data.getScheduleEntity().getId());
            ticketDTO.setSeatId(data.getSeatEntity().getId());
            ticketDTO.setBillTicketDTOList(billTicketMapper.toDTOList(data.getBillTicketEntityList()));
            ticketDTOList.add(ticketDTO);
        }
        return ticketDTOList;
    }

    public List<TicketEntity> toEntityList(List<TicketDTO> ticketDTOList) {
        List<TicketEntity> ticketEntityList = new ArrayList<>();
        for (TicketDTO data : ticketDTOList) {
            TicketEntity ticketEntity = new TicketEntity();
            ticketEntity.setCode(data.getCode());
            ticketEntity.setPriceTicket(data.getPriceTicket());
            ticketEntity.setActive(data.isActive());
            try {
                Optional<ScheduleEntity> scheduleEntityOptional = scheduleRepository.findById(data.getScheduleId());
                ScheduleEntity scheduleEntity = new ScheduleEntity();
                if (scheduleEntityOptional.isPresent()) {
                    scheduleEntity = scheduleEntityOptional.get();
                }
                ticketEntity.setScheduleEntity(scheduleEntity);
            } catch (Exception ex) {

            }
            try {
                Optional<SeatEntity> seatEntityOptional = seatRepository.findById(data.getSeatId());
                SeatEntity seatEntity = new SeatEntity();
                if (seatEntityOptional.isPresent()) {
                    seatEntity = seatEntityOptional.get();
                }
                ticketEntity.setSeatEntity(seatEntity);
            } catch (Exception ex) {

            }
            try {
                ticketEntity.setBillTicketEntityList(billTicketMapper.toEntityList(data.getBillTicketDTOList()));
            } catch (Exception e) {

            }
            ticketEntityList.add(ticketEntity);
        }
        return ticketEntityList;
    }
}
