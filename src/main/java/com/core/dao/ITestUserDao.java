package com.core.dao;


import com.core.pojo.dto.TestMobileDTO;
import com.core.pojo.dto.TestUserDTO;

import java.util.List;
import java.util.Map;


public interface ITestUserDao {
	
	List<TestUserDTO> queryOne2One(Map<String, Object> param);
	
	List<TestUserDTO> queryOne2Many(Map<String, Object> param);
	
	List<TestMobileDTO> queryMany2One(Map<String, Object> param);
	
	List<TestUserDTO> queryMany2Many1(Map<String, Object> param);
	
	List<TestUserDTO> queryMany2Many2(Map<String, Object> param);
}
