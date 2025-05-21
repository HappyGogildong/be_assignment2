package com.be2.scheduler.controller;

import com.be2.scheduler.dto.schedules.request.CreateScheduleRequestDto;
import com.be2.scheduler.dto.schedules.request.DeleteScheduleRequestDto;
import com.be2.scheduler.dto.schedules.request.UpdateScheduleRequestDto;
import com.be2.scheduler.dto.schedules.response.CreateScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.DeleteScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.ScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.UpdateScheduleResponseDto;
import com.be2.scheduler.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    //일정생성
    @PostMapping("/schedules")
    public ResponseEntity<CreateScheduleResponseDto> createSchedule(@RequestBody CreateScheduleRequestDto requestDto){

    }

    //선택일정조회
    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long id){

    }

    //전체일정조회
    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(@RequestParam(required = false) String username, @RequestParam(required = false) LocalDate updatedAt){


    }

    //선택일정수정(작성자명,내용 수정 가능)
    @PatchMapping("/schedules/{id}")
    public ResponseEntity<UpdateScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleRequestDto requestDto){

    }

    //선택일정삭제
    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<DeleteScheduleResponseDto> deleteSchedule(@PathVariable Long id, @RequestBody DeleteScheduleRequestDto requestDto){

    }
}
