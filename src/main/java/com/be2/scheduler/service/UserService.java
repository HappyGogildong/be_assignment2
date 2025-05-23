package com.be2.scheduler.service;


import com.be2.scheduler.dto.users.response.SignUpResponseDto;
import com.be2.scheduler.dto.users.response.UpdateEmailResponseDto;
import com.be2.scheduler.dto.users.response.UpdatePasswordResponseDto;

import com.be2.scheduler.entity.User;
import com.be2.scheduler.exception.InvalidPasswordException;

import com.be2.scheduler.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class UserService implements UserServiceInterface{

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SignUpResponseDto signUp(String username, String password, String email) {

        User user = new User(username, password, email);

        userRepository.signUp(user);

        String message = "회원가입이 완료되었습니다";


        return new SignUpResponseDto(message);
    }

    @Override
    @Transactional
    public UpdatePasswordResponseDto updatePassword(Long userId, String oldPassword, String newPassword) {

        if(userRepository.findById(userId).orElseThrow().getPassword().equals(oldPassword)){
            userRepository.updatePassword(userId, oldPassword, newPassword);
            String message = "비밀번호 변경이 완료되었습니다";
            return new UpdatePasswordResponseDto(message);
        }
         throw new InvalidPasswordException("비밀번호가 다릅니다");


    }

    @Override
    @Transactional
    public UpdateEmailResponseDto updateEmail(Long userId, String email) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.updateEmail(userId, email);
            String message = "이메일 변경이 완료되었습니다";
            return new UpdateEmailResponseDto(message);
        }
        throw new InvalidPasswordException("비밀번호가 다릅니다");
    }
}
