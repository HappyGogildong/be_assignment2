package com.be2.scheduler.dto.users.request;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdatePasswordRequestDto {

    @NotBlank
    private final String oldPassword;

    @NotBlank
    private final String newPassword;
}
