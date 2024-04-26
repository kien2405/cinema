package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.dto.CinemaDTO;
import com.example.ThucTapLTS.dto.RoomDTO;
import com.example.ThucTapLTS.dto.ScheduleDTO;
import com.example.ThucTapLTS.mapper.ScheduleMapper;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.service.imp.ScheduleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleServiceImp scheduleServiceImp;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @PostMapping("/crud/add")
    public ResponseEntity<?> addSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        scheduleServiceImp.addSchedule(scheduleMapper.toEntity(scheduleDTO));
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Thêm lịch chiếu phim thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
