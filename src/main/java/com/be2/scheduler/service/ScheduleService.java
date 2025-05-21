package com.be2.scheduler.service;

import com.be2.scheduler.dto.schedules.response.CreateScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.DeleteScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.ScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.UpdateScheduleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService implements ScheduleServiceInterface {

    @Override
    public CreateScheduleResponseDto createSchedule(String username, String title, String contents) {
        return null;
    }

    @Override
    public ScheduleResponseDto findById(Long id) {
        return null;
    }

    @Override
    public List<ScheduleResponseDto> findAllByUsernameAndUpdateAt(String username, LocalDate modifiedAt) {
        return List.of();
    }


    @Override
    public UpdateScheduleResponseDto updateSchedule(Long id, String password) {
        return null;
    }

    @Override
    public DeleteScheduleResponseDto deleteSchedule(Long id, String password) {
        return null;
    }
}
