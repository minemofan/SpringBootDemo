package com.core.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.core.dao.IDemoDao;
import com.core.pojo.dto.TestMobileDTO;
import com.core.pojo.dto.TestUserDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
//@Repository("iDemoDao")
public class DemoDaoImpl implements IDemoDao {
	
	//@Resource
	private SqlSessionTemplate sqlSession;
	
	private static final String sqlStr = "com.core.dao.mapper.ITestUserMapper.";
	
	@Override
	public List<TestUserDTO> queryOne2One(Map<String,Object> param){
		// TODO Auto-generated method stub
		List<TestUserDTO> list = sqlSession.selectList(sqlStr +"queryOne2One",param);
		return list;
	}

	@Override
	public List<TestUserDTO> queryOne2Many(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<TestUserDTO> list = sqlSession.selectList(sqlStr +"queryOne2Many",param);
		return list;
	}
	
	@Override
	public List<TestMobileDTO> queryMany2One(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<TestMobileDTO> list = sqlSession.selectList(sqlStr +"queryMany2One",param);
		return list;
	}

	@Override
	public List<TestUserDTO> queryMany2Many1(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<TestUserDTO> list = sqlSession.selectList(sqlStr +"queryMany2Many1",param);
		return list;
	}

	@Override
	public List<TestUserDTO> queryMany2Many2(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<TestUserDTO> list = sqlSession.selectList(sqlStr +"queryMany2Many2",param);
		return list;
	}
}
