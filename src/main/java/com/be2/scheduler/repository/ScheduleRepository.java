package com.be2.scheduler.repository;

import com.be2.scheduler.dto.schedules.response.CreateScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.ScheduleResponseDto;
import com.be2.scheduler.entity.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository {


    //일정 생성
    CreateScheduleResponseDto createSchedule(Schedule schedule);

    //선택 일정 조회
    Schedule findById(Long scheduleId);

    //전체 일정 조회(작성자명, 수정일) Lv2
    List<ScheduleResponseDto> findAllByUsernameAndUpdatedAt(String username, LocalDate modifiedAt);

    //전체 일정 조회(작성자 id) Lv3
    List<ScheduleResponseDto> findAllByUserId(Long userId);

    //선택 일정 수정
    int updateSchedule(Long scheduleId, String username, String contents);

    //선택 일정 삭제
    int deleteSchedule(Long scheduleId);





}
