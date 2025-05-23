package com.be2.scheduler.repository;


import com.be2.scheduler.dto.users.response.SignUpResponseDto;
import com.be2.scheduler.entity.User;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcTemplateUserRepository implements UserRepository {

    private final JdbcTemplate jdbcTemplate;


    public JdbcTemplateUserRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public SignUpResponseDto signUp(User user) {

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);

        jdbcInsert.withTableName("user").usingGeneratedKeyColumns("userId");

        LocalDateTime now = LocalDateTime.now();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("userId", user.getUserId());
        parameters.put("password", user.getPassword());
        parameters.put("id", user.getUsername());
        parameters.put("email", user.getEmail());
        parameters.put("createdAt", now);
        parameters.put("modifiedAt", now);

        jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        //파라미터 세팅하기 (반환 message)일 때
        String message = "회원가입이 완료되었습니다";

        //회원가입 반환 Dto
        return new SignUpResponseDto(message);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return jdbcTemplate.query("select * from user where userId = ?", userRowMapper(), userId)
                .stream().findAny();
    }

    private RowMapper<User> userRowMapper() {
        return new RowMapper<>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {

                return new User(rs.getLong("userId"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("id"),
                        rs.getObject("createdAt", LocalDate.class),
                        rs.getObject("modifiedAt", LocalDate.class));
            }
        };
    }

    //비밀번호 변경
    @Override
    @Transactional
    public int updatePassword(Long userId, String oldPassword, String newPassword) {
        return jdbcTemplate.update("update user set password = ?, modifiedAt = ? where userId = ?", newPassword, LocalDate.now(), userId);
    }

    //이메일 변경
    @Override
    @Transactional
    public int updateEmail(Long userId, String email) {
        return jdbcTemplate.update("update user set email = ?, modifiedAt = ? where userId = ?", email,LocalDate.now(), userId);
    }
}
