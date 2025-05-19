 | 기능       | Method | URL                                | request      | response | 상태코드     |
|----------|--------|------------------------------------|--------------|----------|----------|
 | 회원가입     | POST   | /signup                            | 요청 body      | 가입 완료 알림 | 200:정상가입 | |
 | 일정 생성    | POST   | /schedule                          |              |          |          |
 | 전체 일정 조회 | GET    | /schedule                          |              |          |          |
 | 선택 일정 조회 | GET    | /schedule/{schedule_id} |         |          |          |
 | 선택 일정 수정 | PATCH  | /schedule/{schedule_id}                              |              |          |          |
 | 선택 일정 삭제 | DELETE | /schedule/{schedule_id}                             |              |          |          |
 | 비밀번호 변경  | PATCH  | /schedule/{username}                       |              |          |          |
 | 이메일 변경   | PATCH  | /schedule/{username}                                 |              |          |          |
 