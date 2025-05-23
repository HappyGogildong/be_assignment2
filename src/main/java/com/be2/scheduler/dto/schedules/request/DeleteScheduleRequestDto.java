package com.be2.scheduler.dto.schedules.request;

import lombok.Getter;

@Getter
public class DeleteScheduleRequestDto {

    private final String password;

    public DeleteScheduleRequestDto(String password) {
        this.password = password;
    }
}
