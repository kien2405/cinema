package com.example.cinema.service;

import com.example.cinema.dto.request.MailRequest;
import jakarta.mail.MessagingException;

public interface MailService {
    void sendHtmlMail(MailRequest request, String templateName) throws MessagingException;

    String mailRequest(String email);

}
