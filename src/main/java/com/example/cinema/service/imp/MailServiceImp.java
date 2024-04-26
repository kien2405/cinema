package com.example.ThucTapLTS.service.imp;

import com.example.ThucTapLTS.dto.MailDTO;
import jakarta.mail.MessagingException;

public interface MailServiceImp {
    boolean create(String email);
    void sendHtmlMail(MailDTO dataMail, String templateName) throws MessagingException;

    boolean confirmPayment(String email, int id, String vnp_TmnCode, String vnp_Amount);
}
