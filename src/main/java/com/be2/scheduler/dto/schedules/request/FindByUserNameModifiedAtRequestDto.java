package com.be2.scheduler.dto.schedules.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FindByUserNameModifiedAtRequestDto {

    private final String username;

    private final LocalDate modifiedAt;

    public FindByUserNameModifiedAtRequestDto(String username, LocalDate modifiedAt) {
        this.username = username;
        this.modifiedAt = modifiedAt;
    }
}
