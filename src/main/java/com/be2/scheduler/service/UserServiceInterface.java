package com.be2.scheduler.service;


import com.be2.scheduler.dto.users.response.SignUpResponseDto;
import com.be2.scheduler.dto.users.response.UpdateEmailResponseDto;
import com.be2.scheduler.dto.users.response.UpdatePasswordResponseDto;



public interface UserServiceInterface {

    //회원가입
    SignUpResponseDto signUp(String id, String password, String email);
    //비밀번호 변경
    UpdatePasswordResponseDto updatePassword(Long userId, String oldPassword, String newPassword);
    //이메일 변경
    UpdateEmailResponseDto updateEmail(Long userId, String email);

}
