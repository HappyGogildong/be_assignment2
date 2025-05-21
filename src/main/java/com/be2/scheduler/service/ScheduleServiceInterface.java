package com.be2.scheduler.service;

import com.be2.scheduler.dto.schedules.request.CreateScheduleRequestDto;
import com.be2.scheduler.dto.schedules.response.CreateScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.DeleteScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.ScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.UpdateScheduleResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleServiceInterface {

    //일정 생성
    public CreateScheduleResponseDto createSchedule(String username, String title, String contents);
    //선택 일정 조회
    public ScheduleResponseDto findById(Long id);
    //전체 일정 조회(작성자명, 수정일) Lv2 필수
    public List<ScheduleResponseDto> findAllByUsernameAndUpdateAt(String username, LocalDate modifiedAt);
    //선택 일정 수정
    public UpdateScheduleResponseDto updateSchedule(Long id, String password);
    //선택 일정 삭제
    public DeleteScheduleResponseDto deleteSchedule(Long id, String password);
}
