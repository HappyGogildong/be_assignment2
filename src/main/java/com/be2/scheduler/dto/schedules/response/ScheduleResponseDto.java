package com.be2.scheduler.dto.schedules.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private final Long scheduleId;

    private final String username;

    private final String title;

    private final LocalDate createdAt;

    private final LocalDate modifiedAt;

}
