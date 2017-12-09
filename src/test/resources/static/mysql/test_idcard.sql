CREATE TABLE `test_boot`.`test_idcard` (
`i_id`  int NOT NULL ,
`i_code`  varchar(20) NULL ,
`i_remark`  varchar(100) NULL ,
PRIMARY KEY (`i_id`),
CONSTRAINT `test_idcard_fk` FOREIGN KEY (`i_id`) REFERENCES `test_boot`.`test_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
);



INSERT INTO `test_boot`.`test_idcard` VALUES (1, '111111', '用户1');
INSERT INTO `test_boot`.`test_idcard` VALUES (2, '222222', '用户2');
INSERT INTO `test_boot`.`test_idcard` VALUES (3, '333333', '用户3');