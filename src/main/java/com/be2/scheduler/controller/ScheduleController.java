package com.be2.scheduler.controller;

import com.be2.scheduler.dto.schedules.request.CreateScheduleRequestDto;
import com.be2.scheduler.dto.schedules.request.DeleteScheduleRequestDto;
import com.be2.scheduler.dto.schedules.request.UpdateScheduleRequestDto;
import com.be2.scheduler.dto.schedules.response.*;
import com.be2.scheduler.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

        CreateScheduleResponseDto createScheduleResponseDto =
                scheduleService.createSchedule(
                        requestDto.getUserId(),
                        requestDto.getUsername(),
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getPassword()
                );
        return new ResponseEntity<>(createScheduleResponseDto, HttpStatus.CREATED);

    }

    //선택일정조회
    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> findByScheduleId(@PathVariable Long scheduleId){
        ScheduleResponseDto scheduleResponseDto = scheduleService.findByScheduleId(scheduleId);

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);

    }

    //전체일정조회(작성자명, 수정일)
    @GetMapping(value = "/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAllByUsernameAndModifiedAt(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) LocalDate modifiedAt)
    {
        return new ResponseEntity<>(scheduleService.findAllByUsernameAndUpdateAt(username, modifiedAt), HttpStatus.OK);
    }

    //전체일정조회(작성자id)
    @GetMapping(value = "/schedules/{userId}/schedule")
    public ResponseEntity<List<ScheduleResponseDto>> findAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(scheduleService.findAllByUserId(userId));
    }

    //선택일정수정(작성자명,내용 수정 가능)
    @PatchMapping("/schedules/{scheduleId}")
    public ResponseEntity<UpdateScheduleResponseDto> updateSchedule(@PathVariable Long scheduleId, @RequestBody UpdateScheduleRequestDto requestDto){

        return new ResponseEntity<>(scheduleService.updateSchedule(
                scheduleId,
                requestDto.getPassword(),
                requestDto.getUsername(),
                requestDto.getContents()), HttpStatus.OK);
    }

    //선택일정삭제
    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<DeleteScheduleResponseDto> deleteSchedule(@PathVariable Long scheduleId, @RequestBody DeleteScheduleRequestDto requestDto){
        return new ResponseEntity<>(scheduleService.deleteSchedule(scheduleId, requestDto.getPassword()), HttpStatus.OK);
    }

    //페이지네이션 구현
    @GetMapping("/schedules/pages")
    public ResponseEntity<List<ScheduleResponseForPagingDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10", required = false) int size
    ){
        return new ResponseEntity<>(scheduleService.findAll(page, size), HttpStatus.OK);
    }
}
