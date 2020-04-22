CREATE SCHEMA `java_io_nio`;

CREATE TABLE if not exists `java_io_nio`.`account`
(
    `account_id`   INT          NOT NULL AUTO_INCREMENT,
    `account_name` VARCHAR(255) NULL,
    `status`       VARCHAR(255) NULL,
PRIMARY KEY (`account_id`)
);

CREATE TABLE if not exists `java_io_nio`.`developer`
(
    `developer_id` INT          NOT NULL AUTO_INCREMENT,
    `id_account`   INT          NULL,
    `id_skills`    VARCHAR(255) NULL,
PRIMARY KEY (`developer_id`)
);

CREATE TABLE if not exists `java_io_nio`.`skills`
(
    `skills_id`  INT          NOT NULL AUTO_INCREMENT,
    `skill_name` VARCHAR(255) NULL,
PRIMARY KEY (`skills_id`)
);