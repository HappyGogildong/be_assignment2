package com.be2.scheduler.dto.schedules.request;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {
    private final String username;

    private final Long userId;

    private final String title;

    private final String contents;


    private final String password;


    public CreateScheduleRequestDto(Long userId, String username, String title, String contents, String password) {

        this.userId = userId;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.password = password;
    }
}
