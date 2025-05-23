package com.be2.scheduler.controller;


import com.be2.scheduler.dto.users.request.SignUpRequestDto;
import com.be2.scheduler.dto.users.request.UpdateEmailRequestDto;
import com.be2.scheduler.dto.users.request.UpdatePasswordRequestDto;
import com.be2.scheduler.dto.users.response.SignUpResponseDto;
import com.be2.scheduler.dto.users.response.UpdateEmailResponseDto;
import com.be2.scheduler.dto.users.response.UpdatePasswordResponseDto;
import com.be2.scheduler.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/users")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody @Valid SignUpRequestDto requestDto) {
        return new ResponseEntity<>(userService.signUp(requestDto.getId(),requestDto.getPassword(), requestDto.getEmail()), HttpStatus.CREATED);
    }

    //비밀번호 변경
    @PatchMapping("/users/{userId}/password")
    public ResponseEntity<UpdatePasswordResponseDto> updatePassword(@PathVariable Long userId, @RequestBody @Valid UpdatePasswordRequestDto requestDto) {
        return new ResponseEntity<>(userService.updatePassword(userId, requestDto.getOldPassword(), requestDto.getNewPassword()), HttpStatus.OK);
    }

    //이메일 변경
    @PatchMapping("/users/{userId}/email")
    public ResponseEntity<UpdateEmailResponseDto> updateEmail(@PathVariable Long userId, @RequestBody @Valid UpdateEmailRequestDto requestDto) {
        return new ResponseEntity<>(userService.updateEmail(userId, requestDto.getEmail()), HttpStatus.OK);
    }

}
