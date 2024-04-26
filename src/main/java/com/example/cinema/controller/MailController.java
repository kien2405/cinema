package com.example.ThucTapLTS.controller;

import com.example.ThucTapLTS.payload.request.ChangePasswordRequest;
import com.example.ThucTapLTS.payload.request.MailRequest;
import com.example.ThucTapLTS.payload.response.BaseResponse;
import com.example.ThucTapLTS.service.imp.MailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailServiceImp mailServiceImp;

    @PostMapping("/createMail")
    public ResponseEntity<?> createMail(@RequestBody MailRequest mailRequest) {
        mailServiceImp.create(mailRequest.getEmail());
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Gửi mail thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/confirmPayment")
    public ResponseEntity<?> confirmPayment(@RequestParam String email,
                                            @RequestParam int id,
                                            @RequestParam String vnp_Amount,
                                            @RequestParam String vnp_BankCode,
                                            @RequestParam String vnp_BankTranNo,
                                            @RequestParam String vnp_CardType,
                                            @RequestParam String vnp_OrderInfo,
                                            @RequestParam String vnp_PayDate,
                                            @RequestParam String vnp_ResponseCode,
                                            @RequestParam String vnp_TmnCode,
                                            @RequestParam String vnp_TransactionNo,
                                            @RequestParam String vnp_TransactionStatus,
                                            @RequestParam String vnp_TxnRef,
                                            @RequestParam String vnp_SecureHash
                                            ) {
        mailServiceImp.confirmPayment(email, id, vnp_TxnRef, vnp_Amount);
        BaseResponse response = new BaseResponse();
        response.setStatusCode(200);
        response.setMessage("Gửi mail thành công");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
