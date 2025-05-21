package com.be2.scheduler.repository;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcTemplateUserRepository implements UserRepository {
    @Override
    public int updatePassword(Long user_id, String oldPassword, String newPassword) {
        return 0;
    }

    @Override
    public int updateEmail(Long user_id, String email) {
        return 0;
    }
}
