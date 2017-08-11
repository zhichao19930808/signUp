DROP DATABASE IF EXISTS db_test;
CREATE DATABASE db_test;

DROP TABLE IF EXISTS db_test.user;
CREATE TABLE db_test.user (
  id       INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'ID PK',
  userName VARCHAR(40) NOT NULL UNIQUE
  COMMENT '用户名',
  password VARCHAR(40) NOT NULL
  COMMENT '密码',
  email    VARCHAR(40) NOT NULL
  COMMENT '邮箱',
  birthday DATE        NOT NULL
  COMMENT '生日'
);

INSERT INTO db_test.user(userName, password, email, birthday) VALUES (?,?,?,?);
SELECT *
FROM db_test.user;
