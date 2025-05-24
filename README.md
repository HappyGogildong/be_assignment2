## KAKAOTECHCAMPUS 2차 과제 <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">

---

지금까지 들은 Spring 강의를 토대로 일정관리를 위한 CRUD API 만들어 보기

---

### 요구 기능

---

일정 생성 
일정 수정
일정 삭제
일정 조회

회원 가입
이메일 수정
비밀번호 수정

---



### API 명세

---
| 기능      | Method | URL                      | request                                                                      | response                                                                                                                                                                                                                                                                                               | 상태코드     |
|---------|--------|--------------------------|------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|
 | 회원가입    | POST   | /users/signup            | {<br/>"id": "아이디",<br/>"password": "비밀번호"<br/>}                              | {<br/>"message": "회원가입이 완료되었습니다"<br/>}                                                                                                                                                                                                                                                                 | 200:정상가입 | |
 | 일정 생성   | POST   | /schedules               | {<br/>"username": "작성자명",<br/>"title": "제목",<br/>"contents": "내용"<br/>}      | {<br/>"message": "일정이 생성되었습니다",<br/>"scheduleId": "일정id",<br/>"username": "작성자명"<br/>}                                                                                                                                                                                                                       | 201:생성됨  |
 | 전체 일정 조회 | GET    | /schedules               | {<br/>"userId": "작성자id"<br/>}                                                | {<br/> "schedules" : [<br/>{<br/>"schedule_id": "일정 아이디",<br/>"username": "작성자명",<br/> "title":"제목",<br/>"createdAt": "생성일,<br/>"updatedAt": "수정일"<br/>},<br/>{<br/>"schedule_id": "일정 아이디",<br/>"username": "작성자명",<br/> "title":"제목",<br/>"createdAt": "생성일<br/>"updatedAt": "수정일"<br/>}<br/>]<br/>} | 200:OK   |
 | 전체 일정 조회 | GET    | /schedules               | query string을 사용한다 /schedules?username=홍길동&modifiedAt=2025-05-22&userId=1    | {<br/> "schedules" : [<br/>{<br/>"schedule_id": "일정 아이디",<br/>"username": "작성자명",<br/> "title":"제목",<br/>"createdAt": "생성일,<br/>"updatedAt": "수정일"<br/>},<br/>{<br/>"schedule_id": "일정 아이디",<br/>"username": "작성자명",<br/> "title":"제목",<br/>"createdAt": "생성일<br/>"updatedAt": "수정일"<br/>}<br/>]<br/>} | 200:OK   |
 | 선택 일정 조회 | GET    | /schedules/{scheduleId}  |                                                                              | {<br/> "schedules" : <br/>{<br/>"schedule_id": "일정 아이디",<br/>"username": "작성자명",<br/> "title":"제목",<br/>"createdAt": "생성일,<br/>"updatedAt": "수정일"<br/>},<br/>                                                                                                                                          | 200:OK   |
 | 선택 일정 수정 | PATCH  | /schedules/{scheduleId}  | {<br/>"username": "작성자명",<br/>"contents": "내용"<br/>,"password": "비밀번호"<br/>} | {<br/>"message": "일정이 수정되었습니다",<br/>"scheduleId": "일정id",<br/>"username": "작성자명"<br/>}                                                                                                                                                                                                                                                                   | 200:OK   |
 | 선택 일정 삭제 | DELETE | /schedules/{scheduleId}  | {<br/>"password": "비밀번호"<br/>}                                               | {<br/>"message": "일정이 삭제되었습니다",<br/>"scheduleId": "일정id",<br/>"username": "작성자명"<br/>}                                                                                                                                                                                                                                                                   | 200:OK   |
 | 비밀번호 변경 | PATCH  | /users/{userId}/password | {<br/>"oldPassword": "예전 비밀번호",<br/>"newPassword": "새로운 비밀번호"<br/>}          | {<br/>"message": "비밀번호가 변경되었습니다"<br/>}                                                                                                                                                                                                                                                                 | 200:OK   |
 | 이메일 변경  | PATCH  | /users/{userId}/email    | {<br/>"newEmail": "새로운 이메일"<br/>}                                            | {<br/>"message": "이메일이 변경되었습니다"<br/>}                                                                                                                                                                                                                                                                  | 200:OK   |

--- 

### ERD스키마
![ERD스키마](https://github.com/HappyGogildong/be_assignment2/blob/main/image.png)

---