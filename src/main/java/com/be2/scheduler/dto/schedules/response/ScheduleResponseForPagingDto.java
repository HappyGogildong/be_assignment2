package com.be2.scheduler.dto.schedules.response;

import lombok.Getter;

@Getter
public class ScheduleResponseForPagingDto {

    private final String title;

    public ScheduleResponseForPagingDto(String title) {
        this.title = title;
    }
}
