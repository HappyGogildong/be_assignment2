package com.be2.scheduler.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class User {

    private Long userId;
    private String password;
    private String username;
    private String email;
    private LocalDate createdAt;
    private LocalDate modifiedAt;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
