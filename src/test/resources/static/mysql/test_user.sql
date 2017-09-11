CREATE TABLE `springmvcmybatis_schema`.`test_user` (
  `u_id` INT NOT NULL AUTO_INCREMENT,
  `u_name` VARCHAR(20) NULL,
  `u_type` VARCHAR(1) NULL DEFAULT 0,
  `u_money` DECIMAL(20,4) NULL,
  `u_birthdate` DATE NULL,
  `u_time` TIME NULL,
  `u_remark` BLOB NULL,
  PRIMARY KEY (`u_id`));

  
 
INSERT INTO `springmvcmybatis_schema`.`test_user` (`u_id`, `u_name`, `u_type`, `u_money`, `u_birthdate`, `u_time`)
 		VALUES ('1', 'demo1', '0', '1.1110', '20150411', '160808');
INSERT INTO `springmvcmybatis_schema`.`test_user` (`u_id`, `u_name`, `u_type`, `u_money`, `u_birthdate`, `u_time`)
 		VALUES ('2', 'demo2', '1', '7.1117', '20150816', '160808');
INSERT INTO `springmvcmybatis_schema`.`test_user` (`u_id`, `u_name`, `u_type`, `u_money`, `u_birthdate`, `u_time`)
 		VALUES ('3', 'demo3', '1', '9.1119', '20150816', '160808');
        