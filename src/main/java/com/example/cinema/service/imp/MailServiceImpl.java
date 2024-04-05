package com.example.cinema.service.imp;

import com.example.cinema.dto.request.MailRequest;

import com.example.cinema.entity.ConfirmEmailEntity;
import com.example.cinema.entity.UserEntity;

import com.example.cinema.enums.ErrorCode;
import com.example.cinema.exception.AppException;
import com.example.cinema.repository.ComfirmEmailRepository;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.service.MailService;
import com.example.cinema.service.utils.Const;
import com.example.cinema.service.utils.DataUtils;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    SpringTemplateEngine templateEngine;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ComfirmEmailRepository comfirmEmailRepository;

    Instant LAST_TIME_SENT_MAIL = Instant.EPOCH;


    @Override
    public void sendHtmlMail(MailRequest request, String templateName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

        Context context = new Context();
        context.setVariables(request.getProps());

        String html = templateEngine.process(templateName, context);

        helper.setTo(request.getTo());
        helper.setSubject(request.getSubject());
        helper.setText(html, true);

        mailSender.send(message);
    }

    @Override
    public String mailRequest(String email) {
        if (Duration.between(LAST_TIME_SENT_MAIL, Instant.now()).getSeconds() < 60) {
            throw new AppException(ErrorCode.RESEND_TOO_SOON);
        }
        try {
            UserEntity user = userRepository.findByEmail(email)
                    .orElseThrow(()-> new AppException(ErrorCode.WRONG_EMAIL));

            MailRequest dataMail = new MailRequest();

            var otp = DataUtils.generateTempPwd();

            dataMail.setTo(email);
            dataMail.setSubject(Const.SEND_MAIL_SUBJECT.CLIENT_REGISTER);

            Map<String, Object> props = new HashMap<>();
            props.put("name", user.getName());
            props.put("username", user.getUsername());
            props.put("password", otp);
            dataMail.setProps(props);

            sendHtmlMail(dataMail, Const.TEMPLATE_FILE_NAME.CLIENT_REGISTER);


            ConfirmEmailEntity code = new ConfirmEmailEntity();
            code.setConfirmCode(otp);
            code.setUser(user);

            code.setExpiredTime(new Date(
                    Instant.now().plus(1, ChronoUnit.MINUTES).toEpochMilli()));

            comfirmEmailRepository.save(code);
            LAST_TIME_SENT_MAIL = Instant.now();

        } catch (MessagingException exp) {
            exp.printStackTrace();
        }


        return Const.SENDING_EMAIL.CLIENT_REGISTER;

    }
}
