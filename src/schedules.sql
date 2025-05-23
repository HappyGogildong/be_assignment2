create table user(
    userId BIGINT AUTO_INCREMENT PRIMARY KEY,
    id VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(254) UNIQUE,
    createdAt date NOT NULL,
    modifiedAt date NOT NULL
);

create table schedule(
    scheduleId BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId BIGINT NOT NULL,
    username VARCHAR(100) NOT NULL,
    title VARCHAR(100) NOT NULL,
    contents VARCHAR(200) NOT NULL,
    password VARCHAR(100) NOT NULL,
    createdAt date NOT NULL,
    modifiedAt date NOT NULL,

    CONSTRAINT fk_1 FOREIGN KEY (userId)
                     REFERENCES user(userId)
                     ON DELETE CASCADE
);

drop table schedule;
drop table user;

use schedules;