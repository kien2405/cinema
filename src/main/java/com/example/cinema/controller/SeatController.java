package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.dto.CinemaDTO;
import com.example.ThucTapLTS.dto.SeatDTO;
import com.example.ThucTapLTS.entity.CinemaEntity;
import com.example.ThucTapLTS.entity.SeatEntity;
import com.example.ThucTapLTS.mapper.SeatMapper;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.repository.SeatRepository;
import com.example.ThucTapLTS.service.imp.SeatServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    private SeatServiceImp seatServiceImp;

    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private SeatRepository seatRepository;

    @PostMapping("/crud/add")
    public ResponseEntity<?> addSeat(@RequestBody SeatDTO seatDTO) {
        seatServiceImp.addSeat(seatMapper.toEntity(seatDTO));
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Thêm ghế ngồi thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/crud/edit/{id}")
    public ResponseEntity<?> editSeat(@RequestBody SeatDTO seatDTO,
                                      @PathVariable int id) {
        SeatEntity seatEntity = seatMapper.toEntity(seatDTO);
        seatEntity.setId(id);
        seatServiceImp.editSeat(seatEntity);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Sửa ghế ngồi thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/crud/delete/{id}")
    public ResponseEntity<?> deleteSeat(@PathVariable int id) {
        seatServiceImp.deleteSeat(id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Xóa ghế ngồi thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/showSeatByScheduleId/{id}")
    public ResponseEntity<?> showSeatByScheduleId(@PathVariable int id) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(seatMapper.toSeatDTOList(seatServiceImp.showSeatByScheduleId(id)
        ));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
