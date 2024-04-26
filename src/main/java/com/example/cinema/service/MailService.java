package com.example.ThucTapLTS.service;

import com.example.ThucTapLTS.dto.MailDTO;
import com.example.ThucTapLTS.entity.BillEntity;
import com.example.ThucTapLTS.entity.BillStatusEntity;
import com.example.ThucTapLTS.entity.ConfirmEmailEntity;
import com.example.ThucTapLTS.exception.CustomException;
import com.example.ThucTapLTS.repository.BillRepository;
import com.example.ThucTapLTS.repository.BillStatusRepository;
import com.example.ThucTapLTS.repository.ConfirmEmailRepository;
import com.example.ThucTapLTS.repository.UserRepository;
import com.example.ThucTapLTS.scheduledtasks.ConfirmEmailSchedule;
import com.example.ThucTapLTS.service.imp.MailServiceImp;
import com.example.ThucTapLTS.utils.DataUtils;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;

@Service
public class MailService implements MailServiceImp {
    @Autowired
    JavaMailSender mailSender;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConfirmEmailRepository confirmEmailRepository;

    @Autowired
    ConfirmEmailSchedule confirmEmailSchedule;

    @Autowired
    BillRepository billRepository;

    @Autowired
    BillStatusRepository billStatusRepository;

    @Override
    public boolean create(String email) {
        try {
            MailDTO dataMail = new MailDTO();

            dataMail.setTo(email);
            dataMail.setSubject("Xác nhận tạo tài khoản");

            String randomCode = DataUtils.generateTempPwd(6);
            ConfirmEmailEntity confirmEmailEntity = new ConfirmEmailEntity();
            confirmEmailEntity.setUserEntity(userRepository.findByEmail(email));
            confirmEmailEntity.setConfirmCode(randomCode);
            confirmEmailEntity.setConfirm(true);
            confirmEmailRepository.save(confirmEmailEntity);
            confirmEmailSchedule.setTimeActive(confirmEmailEntity);

            Map<String, Object> props = new HashMap<>();
            props.put("email", email);
            props.put("name", userRepository.findByEmail(email).getName());
            props.put("code", randomCode);
            dataMail.setProps(props);

            sendHtmlMail(dataMail, "confirmEmail");
            return true;
        } catch (MessagingException exp){
            exp.printStackTrace();
        }
        return false;
    }

    @Override
    public void sendHtmlMail(MailDTO dataMail, String templateName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        Context context = new Context();
        context.setVariables(dataMail.getProps());
        String html = templateEngine.process(templateName, context);
        helper.setTo(dataMail.getTo());
        helper.setSubject(dataMail.getSubject());
        helper.setText(html, true);
        mailSender.send(message);
    }

    @Override
    public boolean confirmPayment(String email, int id, String vnp_TxnRef, String vnp_Amount) {
        try {
            BillEntity billEntity = billRepository.findById(id).orElseThrow(() -> new CustomException("Không tìm thấy billId"));
            BillStatusEntity billStatusEntity = billStatusRepository.findById(1).orElseThrow(() -> new CustomException("Không tìm thấy billId"));
            billEntity.setActive(true);
            billEntity.setBillStatusEntity(billStatusEntity);
            billRepository.save(billEntity);
            MailDTO dataMail = new MailDTO();

            dataMail.setTo(email);
            dataMail.setSubject("Xác nhận thanh toán");


            Map<String, Object> props = new HashMap<>();
            props.put("email", email);
            props.put("vnp_TxnRef", vnp_TxnRef);
            props.put("vnp_Amount", vnp_Amount);
            props.put("name", userRepository.findByEmail(email).getName());
            dataMail.setProps(props);

            sendHtmlMail(dataMail, "confirmPayment");
            return true;
        } catch (MessagingException exp){
            exp.printStackTrace();
        }
        return false;
    }
}
