package com.example.ThucTapLTS.exception;

import com.example.ThucTapLTS.payload.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalCustomException {

    //  Nơi đăng ký các Exception sẽ kích hoạt code bên trong hàm

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(500);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<?> handleMovieNotFoundException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(404);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CinemaNotFoundException.class)
    public ResponseEntity<?> handleCinemaNotFoundException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(404);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FoodNotFoundException.class)
    public ResponseEntity<?> handleFoodNotFoundException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(404);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MailNotFoundException.class)
    public ResponseEntity<?> handleMailNotFoundException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(404);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<?> handleRoomNotFoundException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(404);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SeatNotFoundException.class)
    public ResponseEntity<?> handleSeatNotFoundException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(404);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ScheduleConflictException.class)
    public ResponseEntity<?> handleScheduleConflictException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(409);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ScheduleNotFoundException.class)
    public ResponseEntity<?> handleScheduleNotFoundException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(409);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<?> handleRoleNotFoundException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(404);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(404);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BillNotFoundException.class)
    public ResponseEntity<?> handleBillNotFoundException(Exception e) {
        BaseResponse response = new BaseResponse();
        response.setStatusCode(404);
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
