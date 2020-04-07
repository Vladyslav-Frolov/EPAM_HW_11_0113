INSERT INTO `java_io_nio`.`status` (`status_id`, `status`) VALUES ('1', 'ACTIVE');
INSERT INTO `java_io_nio`.`status` (`status_id`, `status`) VALUES ('2', 'BANNED');
INSERT INTO `java_io_nio`.`status` (`status_id`, `status`) VALUES ('3', 'DELETED');

INSERT INTO `java_io_nio`.`account` (`account_name`, `id_status`) VALUES ('Vladyslav', '1');
INSERT INTO `java_io_nio`.`account` (`account_name`, `id_status`) VALUES ('Alex', '1');
INSERT INTO `java_io_nio`.`account` (`account_name`, `id_status`) VALUES ('Eugene', '1');
INSERT INTO `java_io_nio`.`account` (`account_name`, `id_status`) VALUES ('Vitaliy', '1');
INSERT INTO `java_io_nio`.`account` (`account_name`, `id_status`) VALUES ('Serge', '1');

INSERT INTO `java_io_nio`.`skills` (`skill_name`) VALUES ('Java');
INSERT INTO `java_io_nio`.`skills` (`skill_name`) VALUES ('C++');
INSERT INTO `java_io_nio`.`skills` (`skill_name`) VALUES ('C#');
INSERT INTO `java_io_nio`.`skills` (`skill_name`) VALUES ('Python');
INSERT INTO `java_io_nio`.`skills` (`skill_name`) VALUES ('Scala');
INSERT INTO `java_io_nio`.`skills` (`skill_name`) VALUES ('Ruby');
INSERT INTO `java_io_nio`.`skills` (`skill_name`) VALUES ('Rails');
INSERT INTO `java_io_nio`.`skills` (`skill_name`) VALUES ('Cotlin');
INSERT INTO `java_io_nio`.`skills` (`skill_name`) VALUES ('PHP');

INSERT INTO `java_io_nio`.`developer` (`id_account`, `id_skills`) VALUES ('1', '8, 4, 1, 6, 9');
INSERT INTO `java_io_nio`.`developer` (`id_account`, `id_skills`) VALUES ('2', '9, 8, 1');
INSERT INTO `java_io_nio`.`developer` (`id_account`, `id_skills`) VALUES ('3', '2, 5, 8, 7, 9, 3, 1, 6, 4');
INSERT INTO `java_io_nio`.`developer` (`id_account`, `id_skills`) VALUES ('4', '8, 1');
INSERT INTO `java_io_nio`.`developer` (`id_account`, `id_skills`) VALUES ('5', '2, 3');
