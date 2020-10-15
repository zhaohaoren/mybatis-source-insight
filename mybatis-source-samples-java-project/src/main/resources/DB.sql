CREATE DATABASE db_mybatis_source_insight;

USE db_mybatis_source_insight;

CREATE TABLE tb_blog
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(50)                         NULL,
    author      VARCHAR(50)                         NULL,
    content     TEXT                                NULL,
    create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
)COMMENT 'blog';
