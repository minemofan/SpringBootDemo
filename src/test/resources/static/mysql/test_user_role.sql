CREATE TABLE `springmvcmybatis_schema`.`test_user_role` (
	`user_id`  int NOT NULL ,
	`role_id`  int NOT NULL ,
	`Description`  varchar(255) NULL ,
	PRIMARY KEY (`user_id`, `role_id`),
	CONSTRAINT `fk_mr` FOREIGN KEY (`user_id`) REFERENCES `springmvcmybatis_schema`.`test_user` (`u_id`),
	CONSTRAINT `fk_mp` FOREIGN KEY (`role_id`) REFERENCES `springmvcmybatis_schema`.`test_role` (`r_id`)
);

INSERT INTO `springmvcmybatis_schema`.`test_user_role` (`user_id`, `role_id`) VALUES ('3', '1');
INSERT INTO `springmvcmybatis_schema`.`test_user_role` (`user_id`, `role_id`) VALUES ('3', '2');
INSERT INTO `springmvcmybatis_schema`.`test_user_role` (`user_id`, `role_id`) VALUES ('2', '2');
INSERT INTO `springmvcmybatis_schema`.`test_user_role` (`user_id`, `role_id`) VALUES ('1', '1');
