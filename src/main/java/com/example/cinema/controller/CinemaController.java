package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.dto.CinemaDTO;
import com.example.ThucTapLTS.dto.FoodDTO;
import com.example.ThucTapLTS.dto.RoomDTO;
import com.example.ThucTapLTS.entity.*;
import com.example.ThucTapLTS.mapper.CinemaMapper;
import com.example.ThucTapLTS.mapper.RoomMapper;
import com.example.ThucTapLTS.mapper.ScheduleMapper;
import com.example.ThucTapLTS.mapper.SeatMapper;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.service.imp.CinemaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    private CinemaServiceImp cinemaServiceImp;

    @Autowired
    private CinemaMapper cinemaMapper;

    @PostMapping("/crud/add")
    public ResponseEntity<?> addCinema(@RequestBody CinemaDTO cinemaDTO) {
        cinemaServiceImp.addCinema(cinemaMapper.toEntity(cinemaDTO));
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Thêm rạp phim thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/crud/edit/{id}")
    public ResponseEntity<?> editCinema(@RequestBody CinemaDTO cinemaDTO,
                                        @PathVariable int id) {
        CinemaEntity cinemaEntity = cinemaMapper.toEntity(cinemaDTO);
        cinemaEntity.setId(id);
        cinemaServiceImp.editCinema(cinemaEntity);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Sửa rạp phim thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/crud/delete/{id}")
    public ResponseEntity<?> deleteCinema(@PathVariable int id) {
        cinemaServiceImp.deleteCinema(id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Xóa rạp phim thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/cinemaSalesStatistics")
    public ResponseEntity<?> getCinemaSalesStatistics(@RequestParam String startTime,
                                                      @RequestParam String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startLocalDate = LocalDate.parse(startTime, formatter);
        LocalDate endLocalDate = LocalDate.parse(endTime, formatter);

        LocalDateTime startDateTime = startLocalDate.atStartOfDay();
        LocalDateTime endDateTime = endLocalDate.atTime(LocalTime.MAX);

        List<Object[]> objects = cinemaServiceImp.cinemaSalesStatistics(startDateTime, endDateTime);
        List<Map<String, Object>> result = new ArrayList<>();
        for (Object[] obj : objects) {
            CinemaEntity cinemaEntity = (CinemaEntity) obj[0];
            double revenue = (double) obj[1] / 2;
            CinemaDTO cinemaDTO = cinemaMapper.toDTO(cinemaEntity);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("CinemaDTO", cinemaDTO);
            resultMap.put("tongDoanhThu", revenue);
            result.add(resultMap);
        }
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(result);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
