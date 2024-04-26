package com.example.ThucTapLTS.scheduledtasks;

import com.example.ThucTapLTS.entity.ConfirmEmailEntity;
import com.example.ThucTapLTS.repository.ConfirmEmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class ConfirmEmailSchedule {
    @Autowired
    ConfirmEmailRepository confirmEmailRepository;

    public void setTimeActive(ConfirmEmailEntity confirmEmailEntity) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> {
            System.out.println("Thực hiện công việc chỉ một lần sau 5 phút.");
            confirmEmailEntity.setConfirm(false);
            confirmEmailEntity.setExpiredTime(LocalDateTime.now());
            confirmEmailRepository.save(confirmEmailEntity);
        }, 5, TimeUnit.MINUTES);
    }
}
