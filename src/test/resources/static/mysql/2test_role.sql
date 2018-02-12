CREATE TABLE `test_boot`.`test_role` (
  `r_id` INT NOT NULL,
  `r_name` VARCHAR(45) NULL,
  PRIMARY KEY (`r_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO `test_boot`.`test_role` (`r_id`, `r_name`) VALUES ('1', '角色1');
INSERT INTO `test_boot`.`test_role` (`r_id`, `r_name`) VALUES ('2', '角色2');
