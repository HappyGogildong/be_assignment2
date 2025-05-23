package com.be2.scheduler.dto.users.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateEmailRequestDto {

    @Email(message = "올바르지 않은 이메일 형식")
    private final String email;


}
