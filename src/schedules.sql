create table user(
    userId BIGINT AUTO_INCREMENT PRIMARY KEY,
    id VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(254) UNIQUE
);

create table schedule(
    scheduleId BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId BIGINT NOT NULL,
    title VARCHAR(100) NOT NULL,
    contents VARCHAR(200) NOT NULL,
    username VARCHAR(100) NOT NULL,
    createdAt date NOT NULL,
    modifiedAt date NOT NULL,

    CONSTRAINT fk_1 FOREIGN KEY (userId)
                     REFERENCES user(userId)
                     ON DELETE CASCADE
);

drop table schedule;
drop table user;