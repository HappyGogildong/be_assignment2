package com.be2.scheduler.dto.schedules.request;

import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {

    private final String username;

    private final String contents;

    private final String password;

    public UpdateScheduleRequestDto(String password, String username, String contents) {
        this.username = username;
        this.contents = contents;
        this.password = password;
    }
}
