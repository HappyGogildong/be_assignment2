package com.be2.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long scheduleId;
    private Long userId;
    private String title;
    private String contents;
    private String username;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

    public Schedule(String title, String contents, String username, LocalDate createdAt, LocalDate modifiedAt) {
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
