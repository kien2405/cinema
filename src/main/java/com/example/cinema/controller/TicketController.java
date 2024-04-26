package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.dto.SeatDTO;
import com.example.ThucTapLTS.dto.TicketDTO;
import com.example.ThucTapLTS.mapper.TicketMapper;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.service.imp.TicketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketServiceImp ticketServiceImp;

    @Autowired
    private TicketMapper ticketMapper;

    @PostMapping("/crud/add")
    public ResponseEntity<?> addTicket(@RequestBody List<TicketDTO> ticketDTOList) {
        ticketServiceImp.addTicket(ticketMapper.toEntityList(ticketDTOList));
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Thêm vé thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
