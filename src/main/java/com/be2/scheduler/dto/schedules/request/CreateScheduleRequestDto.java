package com.be2.scheduler.dto.schedules.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class CreateScheduleRequestDto {
    private final String username;

    private final Long userId;

    private final String title;

    @Length(max = 200)
    private final String contents;

    @NotBlank
    private final String password;


    public CreateScheduleRequestDto(Long userId, String username, String title, String contents, String password) {

        this.userId = userId;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.password = password;
    }
}
