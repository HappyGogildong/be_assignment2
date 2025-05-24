package com.be2.scheduler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ExceptionResponseDto> handleInvalidPasswordException(InvalidPasswordException e){
        ExceptionResponseDto exception = new ExceptionResponseDto(e.getMessage(), 401, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionResponseDto> noSuchElementException(NoSuchElementException e){
        ExceptionResponseDto exception = new ExceptionResponseDto(e.getMessage(), 401, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }
}
