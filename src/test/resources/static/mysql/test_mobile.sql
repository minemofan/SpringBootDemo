CREATE TABLE `test_boot`.`test_mobile` (
`m_id`  int NOT NULL AUTO_INCREMENT ,
`m_mobile_num`  decimal(11) NULL COMMENT '手机号码' ,
`m_remark`  varchar(20) NULL ,
`user_id`  INT NOT NULL,
PRIMARY KEY (`m_id`),
CONSTRAINT `test_mobile_fk_id` FOREIGN KEY (`user_id`) REFERENCES `test_boot`.`test_user` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO `test_boot`.`test_mobile` VALUES (1, '18721491322', '手机1', 1);
INSERT INTO `test_boot`.`test_mobile` VALUES (2, '18721491323', '手机2', 1);
INSERT INTO `test_boot`.`test_mobile` VALUES (3, '18821491322', '手机1', 2);
INSERT INTO `test_boot`.`test_mobile` VALUES (4, '18921491322', '手机1', 3);
INSERT INTO `test_boot`.`test_mobile` VALUES (5, '18921491323', '手机2', 3);
INSERT INTO `test_boot`.`test_mobile` VALUES (6, '18921491324', '手机3', 3);

        