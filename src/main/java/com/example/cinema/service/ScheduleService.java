package com.example.ThucTapLTS.service;

import com.example.ThucTapLTS.entity.ScheduleEntity;
import com.example.ThucTapLTS.exception.ScheduleConflictException;
import com.example.ThucTapLTS.repository.ScheduleRepository;
import com.example.ThucTapLTS.service.imp.ScheduleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService implements ScheduleServiceImp {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void addSchedule(ScheduleEntity scheduleEntity) {
        List<ScheduleEntity> scheduleEntityList = scheduleRepository.findAll();
        for (ScheduleEntity data : scheduleEntityList) {
            // Kiểm tra xem newSchedule có trùng với existingSchedule không
            if ((scheduleEntity.getStartAt().isAfter(data.getStartAt()) &&
                    scheduleEntity.getStartAt().isBefore(data.getEndAt())) ||
                    (scheduleEntity.getEndAt().isAfter(data.getStartAt()) &&
                            scheduleEntity.getEndAt().isBefore(data.getEndAt()))) {
                throw new ScheduleConflictException("Thời gian startAt hoặc endAt của schedule mới trùng với một hoặc nhiều schedule hiện có.");
            }
        }
        scheduleRepository.save(scheduleEntity);
    }
}
