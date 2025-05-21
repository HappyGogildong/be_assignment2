package com.be2.scheduler.dto.schedules.request;

import lombok.Getter;

@Getter
public class CreateScheduleRequestDto {

    private final Long  id;

    private final Long user_id;

    private String title;

    private String content;

    private String username;

    public CreateScheduleRequestDto(Long id, Long user_id, String title, String content, String username) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.username = username;
    }
}
