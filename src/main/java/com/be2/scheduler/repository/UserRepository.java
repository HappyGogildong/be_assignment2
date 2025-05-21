package com.be2.scheduler.repository;

public interface UserRepository {
    //비밀번호 변경하기
    int updatePassword(Long user_id, String oldPassword, String newPassword);

    //이메일 변경하기
    int updateEmail(Long user_id, String email);



}
