package com.be2.scheduler.dto.users.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequestDto {

    private final String id;

    @NotBlank
    private final String password;

    @Email(message = "올바르지 않은 이메일 형식")
    private final String email;
}
