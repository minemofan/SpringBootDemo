package com.core.dao.impl;

import com.core.dao.ITestUserDaoByMapper;
import com.core.dao.mapper.ITestUserMapper;
import com.core.pojo.dto.TestMobileDTO;
import com.core.pojo.dto.TestUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Component
@Repository("iTestUserDaoByMapper")
public class TestUserDaoByMapperImpl implements ITestUserDaoByMapper{

    @Autowired
    private ITestUserMapper iTestUserMapper;


    @Override
    public List<TestUserDTO> queryOne2One(Map<String, Object> param) {
        iTestUserMapper.queryAll();
        return null;
    }

    @Override
    public List<TestUserDTO> queryOne2Many(Map<String, Object> param) {
        return null;
    }

    @Override
    public List<TestMobileDTO> queryMany2One(Map<String, Object> param) {
        return null;
    }

    @Override
    public List<TestUserDTO> queryMany2Many1(Map<String, Object> param) {
        return null;
    }

    @Override
    public List<TestUserDTO> queryMany2Many2(Map<String, Object> param) {
        return null;
    }
}
