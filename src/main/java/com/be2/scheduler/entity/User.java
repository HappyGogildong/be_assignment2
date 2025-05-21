package com.be2.scheduler.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@AllArgsConstructor
public class User {


    private Long userId;
    private final String id;
    private String password;
    private String email;

    public User(String id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }
}
