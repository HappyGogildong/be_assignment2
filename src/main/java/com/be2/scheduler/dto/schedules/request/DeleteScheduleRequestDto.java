package com.be2.scheduler.dto.schedules.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DeleteScheduleRequestDto {

    @NotBlank
    private final String password;

    public DeleteScheduleRequestDto(String password) {
        this.password = password;
    }
}
