package com.be2.scheduler.repository;

import com.be2.scheduler.dto.users.response.SignUpResponseDto;
import com.be2.scheduler.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository {

    //회원가입
    SignUpResponseDto signUp (User user);


    //회원 조회
    Optional<User> findById(Long userId);

    //비밀번호 변경하기
    int updatePassword(Long userId, String oldPassword, String newPassword);

    //이메일 변경하기
    int updateEmail(Long userId, String email);



}
