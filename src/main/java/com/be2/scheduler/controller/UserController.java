package com.be2.scheduler.controller;


import com.be2.scheduler.dto.users.request.SignUpRequestDto;
import com.be2.scheduler.dto.users.request.UpdateEmailRequestDto;
import com.be2.scheduler.dto.users.request.UpdatePasswordRequestDto;
import com.be2.scheduler.dto.users.response.SignUpResponseDto;
import com.be2.scheduler.dto.users.response.UpdateEmailResponseDto;
import com.be2.scheduler.dto.users.response.UpdatePasswordResponseDto;
import com.be2.scheduler.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //회원가입
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

    }

    //비밀번호 변경
    public ResponseEntity<UpdatePasswordResponseDto> updatePassword(@RequestBody UpdatePasswordRequestDto requestDto) {

    }

    //이메일 변경
    public ResponseEntity<UpdateEmailResponseDto> updateEmail(@RequestBody UpdateEmailRequestDto requestDto) {

    }

}
