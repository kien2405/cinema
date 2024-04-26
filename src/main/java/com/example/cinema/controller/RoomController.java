package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.dto.CinemaDTO;
import com.example.ThucTapLTS.dto.RoomDTO;
import com.example.ThucTapLTS.entity.CinemaEntity;
import com.example.ThucTapLTS.entity.RoomEntity;
import com.example.ThucTapLTS.mapper.RoomMapper;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.service.imp.RoomServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomServiceImp roomServiceImp;

    @Autowired
    private RoomMapper roomMapper;

    @PostMapping("/crud/add")
    public ResponseEntity<?> addRoom(@RequestBody RoomDTO roomDTO) {
        roomServiceImp.addRoom(roomMapper.toEntity(roomDTO));
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Thêm phòng chiếu phim thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/crud/edit/{id}")
    public ResponseEntity<?> editRoom(@RequestBody RoomDTO roomDTO,
                                      @PathVariable int id) {
        RoomEntity roomEntity = roomMapper.toEntity(roomDTO);
        roomEntity.setId(id);
        roomServiceImp.editRoom(roomEntity);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Sửa phòng chiếu phim thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/crud/delete/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable int id) {
        roomServiceImp.deleteRoom(id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Xóa phòng chiếu phim thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
