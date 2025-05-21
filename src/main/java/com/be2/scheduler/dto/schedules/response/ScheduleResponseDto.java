package com.be2.scheduler.dto.schedules.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private final Long scheduleId;

    private String username;

    private String title;

    private LocalDate createdAt;

    private LocalDate modifiedAt;

}
