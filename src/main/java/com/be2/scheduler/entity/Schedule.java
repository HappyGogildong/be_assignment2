package com.be2.scheduler.entity;

import com.be2.scheduler.dto.schedules.response.ScheduleResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;



@Getter
@AllArgsConstructor
public class Schedule {

    private Long scheduleId;
    private Long userId;
    private String password;
    private String title;
    private String contents;
    private String username;

    private LocalDate createdAt;
    private LocalDate modifiedAt;

    public Schedule(Long userId, String username, String title, String password, String contents, LocalDate createdAt, LocalDate modifiedAt) {
        this.title = title;
        this.userId = userId;
        this.contents = contents;
        this.password = password;
        this.username = username;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    public ScheduleResponseDto scheduleResponseDto(Long scheduleId) {
        return new ScheduleResponseDto(scheduleId, this.getUsername(), this.getTitle(), this.getCreatedAt(), this.getModifiedAt());
    }
}
