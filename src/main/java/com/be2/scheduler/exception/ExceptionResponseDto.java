package com.be2.scheduler.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ExceptionResponseDto {

    private final String errMessage;

    private final int status;

    private final LocalDateTime timeStamp;


}
