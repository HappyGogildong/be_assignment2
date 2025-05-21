package com.be2.scheduler.service;

import com.be2.scheduler.dto.schedules.response.ScheduleResponseDto;
import com.be2.scheduler.dto.users.response.SignUpResponseDto;
import com.be2.scheduler.dto.users.response.UpdateEmailResponseDto;
import com.be2.scheduler.dto.users.response.UpdatePasswordResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInterface{

    @Override
    public SignUpResponseDto signUp(String id, String password) {
        return null;
    }

    @Override
    public UpdatePasswordResponseDto updatePassword(Long user_id, String old_password, String new_password) {
        return null;
    }

    @Override
    public UpdateEmailResponseDto updateEmail(String email) {
        return null;
    }

    @Override
    public List<ScheduleResponseDto> findByUserId(Long userId) {
        return List.of();
    }
}
