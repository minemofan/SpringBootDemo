CREATE TABLE `test_boot`.`test_product` (
  `p_id` INT NOT NULL COMMENT '产品ID',
  `p_name` VARCHAR(45) NOT NULL COMMENT '产品名称',
  `p_type` VARCHAR(20) NOT NULL COMMENT '产品类型',
  `p_price` VARCHAR(45) NOT NULL COMMENT '产品单价',
  `p_remark` VARCHAR(500) NULL COMMENT '产品描述',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `update_date` DATETIME NOT NULL COMMENT '修改时间',
  `create_by` VARCHAR(45) NOT NULL COMMENT '创建人',
  `update_by` VARCHAR(45) NOT NULL COMMENT '修改人',
  PRIMARY KEY (`p_id`));


ALTER TABLE `test_boot`.`test_product`
CHANGE COLUMN `create_date` `create_date` DATETIME NOT NULL DEFAULT now() COMMENT '创建时间' ,
CHANGE COLUMN `update_date` `update_date` DATETIME NOT NULL DEFAULT now() COMMENT '修改时间' ;


INSERT INTO `test_boot`.`test_product` (`p_id`, `p_name`, `p_type`, `p_price`, `p_remark`, `create_by`, `update_by`) VALUES ('1', '产品1', 'P2P', 1000.88, '产品1的备注', 'sys', 'sys');
INSERT INTO `test_boot`.`test_product` (`p_id`, `p_name`, `p_type`, `p_price`, `p_remark`, `create_by`, `update_by`) VALUES ('2', '产品2', 'FUND', 1222.22, '产品2的备注', 'sys', 'sys');
INSERT INTO `test_boot`.`test_product` (`p_id`, `p_name`, `p_type`, `p_price`, `p_remark`, `create_by`, `update_by`) VALUES ('3', '产品3', 'FUND', 1333.33, '产品3的备注', 'sys', 'sys');




