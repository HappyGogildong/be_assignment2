package com.be2.scheduler.dto.schedules.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteScheduleResponseDto {

    private final String message;

    private final Long scheduleId;

    private final String username;


}
