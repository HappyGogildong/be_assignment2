package com.be2.scheduler.service;


import com.be2.scheduler.dto.schedules.response.*;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleServiceInterface {

    //일정 생성
    CreateScheduleResponseDto createSchedule(Long userId, String username, String password, String title, String contents);
    //선택 일정 조회
    ScheduleResponseDto findByScheduleId(Long scheduleId);
    //전체 일정 조회(작성자명, 수정일) Lv2 필수
    List<ScheduleResponseDto> findAllByUsernameAndModifiedAtAndUserId(String username, LocalDate modifiedAt, Long userId);
    //전체 일정 조회(작성자id) Lv3
//    List<ScheduleResponseDto> findAllByUserId(Long userId);
    //선택 일정 수정
    UpdateScheduleResponseDto updateSchedule(Long scheduleId, String password, String username, String contents);
    //선택 일정 삭제
    DeleteScheduleResponseDto deleteSchedule(Long scheduleId, String password);

    List<ScheduleResponseForPagingDto> findAll(int page, int size);
}
