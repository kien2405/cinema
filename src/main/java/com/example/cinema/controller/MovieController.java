package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.dto.MovieDTO;
import com.example.ThucTapLTS.dto.SeatDTO;
import com.example.ThucTapLTS.entity.MovieEntity;
import com.example.ThucTapLTS.entity.SeatEntity;
import com.example.ThucTapLTS.mapper.CinemaMapper;
import com.example.ThucTapLTS.mapper.MovieMapper;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.payload.response.FeaturedMovieDisplayResponse;
import com.example.ThucTapLTS.service.imp.MovieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieServiceImp movieServiceImp;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private CinemaMapper cinemaMapper;

    @PostMapping("/crud/add")
    public ResponseEntity<?> addMovie(@RequestBody MovieDTO movieDTO) {
        movieServiceImp.addMovie(movieMapper.toEntity(movieDTO));
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Thêm phim thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/crud/edit/{id}")
    public ResponseEntity<?> editMovie(@RequestBody MovieDTO movieDTO,
                                      @PathVariable int id) {
        MovieEntity movieEntity = movieMapper.toEntity(movieDTO);
        movieEntity.setId(id);
        movieServiceImp.editMovie(movieEntity);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Sửa phim thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/crud/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable int id) {
        movieServiceImp.deleteMovie(id);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Xóa phim thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/featuredMovieDisplay")
    public ResponseEntity<?> featuredMovieDisplay() {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        List<FeaturedMovieDisplayResponse> featuredMovieDisplayResponseList = new ArrayList<>();
        for (MovieEntity movieEntity : movieServiceImp.featuredMovieDisplay()) {
            FeaturedMovieDisplayResponse featuredMovieDisplayResponse = new FeaturedMovieDisplayResponse();
            featuredMovieDisplayResponse.setName(movieEntity.getName());
            featuredMovieDisplayResponse.setImage(movieEntity.getImage());
            featuredMovieDisplayResponse.setMovieDuration(movieEntity.getMovieDuration());
            featuredMovieDisplayResponseList.add(featuredMovieDisplayResponse);
        }
        response.setData(featuredMovieDisplayResponseList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/showCinemaRoomSeatByMovie")
    public ResponseEntity<?> showCinemaRoomSeatByMovie(@RequestParam int id) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(cinemaMapper.toCinemaDTOList(movieServiceImp.showCinemaRoomSeatByMovieId(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/showCinemaScheduleByMovie")
    public ResponseEntity<?> showCinemaScheduleByMovie(@RequestParam int id) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setData(cinemaMapper.toCinemaDTOList(movieServiceImp.showCinemaScheduleByMovieId(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
