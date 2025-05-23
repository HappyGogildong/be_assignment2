package com.be2.scheduler.service;

import com.be2.scheduler.dto.schedules.response.*;
import com.be2.scheduler.entity.Schedule;
import com.be2.scheduler.exception.InvalidPasswordException;
import com.be2.scheduler.repository.ScheduleRepository;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ScheduleService implements ScheduleServiceInterface {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    //일정 생성
    @Override
    public CreateScheduleResponseDto createSchedule(Long userId, String username, String title, String contents, String password) {
        LocalDate localDate = LocalDate.now();
        Schedule schedule = new Schedule(userId, username, title, password, contents, localDate, localDate);
        return scheduleRepository.createSchedule(schedule);
    }

    //일정 조회(일정id로 한 개)
    @Override
    public ScheduleResponseDto findByScheduleId(Long scheduleId) {

        return scheduleRepository.findByScheduleId(scheduleId).orElseThrow().scheduleResponseDto(scheduleId);
    }

    //일정 반환(작성자명, 수정일)
    @Override
    public List<ScheduleResponseDto> findAllByUsernameAndUpdateAt(String username, LocalDate modifiedAt) {
        return scheduleRepository.findAllByUsernameAndModifiedAt(username, modifiedAt);
    }

    //일정 반환(작성자id)
    @Override
    public List<ScheduleResponseDto> findAllByUserId(Long userId) {
        return scheduleRepository.findAllByUserId(userId);
    }


    @Override
    @Transactional
    public UpdateScheduleResponseDto updateSchedule(Long scheduleId, String password, String username, String contents) {
        String message = "일정 수정 성공";
        Schedule schedule = scheduleRepository.findByScheduleId(scheduleId).orElseThrow(() ->new NoSuchElementException("해당 일정은 존재하지 않습니다"));

        System.out.println(schedule.getPassword());

        if(schedule.getPassword().equals(password)) {
            scheduleRepository.updateSchedule(scheduleId, username, contents);
            return new UpdateScheduleResponseDto(message, scheduleId, username);
        }
        else throw new InvalidPasswordException("비밀번호가 일치하지 않습니다");
    }

    @Override
    public DeleteScheduleResponseDto deleteSchedule(Long scheduleId, String password) {
        String message = "일정 수정 성공";
        Schedule schedule = scheduleRepository.findByScheduleId(scheduleId).orElseThrow(() ->new NoSuchElementException("해당 일정은 존재하지 않습니다"));
        if(schedule.getPassword().equals(password)) {
            String username = schedule.getUsername();
            scheduleRepository.deleteSchedule(scheduleId);
            return new DeleteScheduleResponseDto(message, scheduleId, username);
        }
        else throw new InvalidPasswordException("비밀번호가 일치하지 않습니다");
    }

    @Override
    //페이징 일정 찾기
    public List<ScheduleResponseForPagingDto> findAll(int page, int size) {

        return scheduleRepository.findAll(page, size);
    }
}
