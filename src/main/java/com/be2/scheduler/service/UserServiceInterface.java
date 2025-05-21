package com.be2.scheduler.service;

import com.be2.scheduler.dto.schedules.response.ScheduleResponseDto;
import com.be2.scheduler.dto.users.request.SignUpRequestDto;
import com.be2.scheduler.dto.users.response.SignUpResponseDto;
import com.be2.scheduler.dto.users.response.UpdateEmailResponseDto;
import com.be2.scheduler.dto.users.response.UpdatePasswordResponseDto;

import java.util.List;

public interface UserServiceInterface {

    //회원가입
    public SignUpResponseDto signUp(String id, String password);
    //비밀번호 변경
    public UpdatePasswordResponseDto updatePassword(Long userId, String oldPassword, String newPassword);
    //이메일 변경
    public UpdateEmailResponseDto updateEmail(String email);
    //작성자(회원)기준 일정 조회
    public List<ScheduleResponseDto> findByUserId(Long userId);
}
