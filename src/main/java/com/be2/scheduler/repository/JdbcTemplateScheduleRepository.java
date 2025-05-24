package com.be2.scheduler.repository;

import com.be2.scheduler.dto.schedules.response.CreateScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.ScheduleResponseDto;
import com.be2.scheduler.dto.schedules.response.ScheduleResponseForPagingDto;
import com.be2.scheduler.entity.Schedule;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.*;

@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //전체(여러 개)일정 반환용 매퍼
    private RowMapper<Schedule> scheduleRowMapper(){
        return new RowMapper<>() {

            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("userId"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("password"),
                        rs.getString("contents"),
                        rs.getObject("createdAt", LocalDate.class),
                        rs.getObject("modifiedAt", LocalDate.class)
                        );
            }
        };
    }

    //페이징용 매퍼
    private RowMapper<ScheduleResponseForPagingDto> schedulePagingRowMapper() {
        return new RowMapper<>() {

            @Override
            public ScheduleResponseForPagingDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseForPagingDto(
                        rs.getString("title")
                );
            }
        };
    }

    //선택 일정 반환용 매퍼
    private RowMapper<ScheduleResponseDto> scheduleResponseDtoRowMapper(){
        return new RowMapper<>() {

            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("scheduleId"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getObject("createdAt",LocalDate.class),
                        rs.getObject("modifiedAt",LocalDate.class)
                );
            }
        };
    }

    //일정 생성
    @Override
    public CreateScheduleResponseDto createSchedule(Schedule schedule) {

        //INSERT 쿼리 대응
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(this.jdbcTemplate);

        //schedule테이블에 key값은 schedule_id로 하여 INSERT
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("scheduleId");

        LocalDate currentDate = LocalDate.now();
        //attribute 넣기
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", schedule.getUsername());
        parameters.put("title", schedule.getTitle());
        parameters.put("userId", schedule.getUserId());
        parameters.put("password", schedule.getPassword());
        parameters.put("contents", schedule.getContents());
        parameters.put("createdAt", currentDate);
        parameters.put("modifiedAt", currentDate);

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        Long scheduleId = key.longValue();

        //파라미터 세팅하기 (반환 message)일 때
        String message = "일정생성이 완료되었습니다";

        //회원가입 반환 Dto
        return new CreateScheduleResponseDto(message,scheduleId, schedule.getUsername());

    }

    //선택 일정 조회(URL 일정id)
    @Override
    public Optional<Schedule> findByScheduleId(Long scheduleId) {
        return jdbcTemplate.query("select * from schedule where scheduleId = ?", scheduleRowMapper(), scheduleId)
                .stream().findAny();
    }

    //전체 일정 조회(작성자명, 수정일) Lv2
    @Override
    public List<ScheduleResponseDto> findAllByUsernameAndModifiedAtAndUserId(String username, LocalDate modifiedAt, Long userId) {
        StringBuilder sql = new StringBuilder("SELECT * FROM schedule WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (username != null && !username.isBlank()) {
            sql.append(" AND username = ?");
            params.add(username);
        }

        if (modifiedAt != null) {
            sql.append(" AND modifiedAt = ?");
            params.add(modifiedAt);
        }

        if(userId != null) {
            sql.append(" AND userId = ?");
            params.add(userId);
        }

        return jdbcTemplate.query(sql.toString(), scheduleResponseDtoRowMapper(), params.toArray());
    }


    //전체 일정 조회(작성자 id) Lv3
    @Override
    public List<ScheduleResponseDto> findAllByUserId(Long userId) {
        return jdbcTemplate.query("select * from schedule where userId = ?", scheduleResponseDtoRowMapper(), userId);
    }

    //선택 일정 수정
    @Override
    public int updateSchedule(Long scheduleId, String username, String contents) {
        return jdbcTemplate.update("update schedule set username = ?, contents = ? where scheduleId = ?", username, contents, scheduleId);
    }

    //선택 일정 삭제
    @Override
    public int deleteSchedule(Long scheduleId) {
        return jdbcTemplate.update("delete from schedule where scheduleId = ?", scheduleId);
    }

    @Override
    //페이지 단위 조회
    public List<ScheduleResponseForPagingDto> findAll(int page, int size) {
        int offset = page * size;

        return jdbcTemplate.query("SELECT title FROM schedule ORDER BY createdAt DESC LIMIT ? OFFSET ?", schedulePagingRowMapper(), size, offset);
    }


}
