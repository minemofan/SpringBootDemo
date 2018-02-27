package com.core.service.impl;

import com.core.dao.ITestUserDao;
import com.core.pojo.dto.TestMobileDTO;
import com.core.pojo.dto.TestUserDTO;
import com.core.service.ITestUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestUserServiceImpl implements ITestUserService{

    protected static Logger _logger = LoggerFactory.getLogger(TestUserServiceImpl.class);


    /**
     * DAO的方式  */
    @Autowired
    private ITestUserDao iTestUserDao;


    //--------------------------------------------------   DAO  方式

    @Override
    public List<TestUserDTO> queryOne2One(Map<String, Object> param) {
        // TODO Auto-generated method stub
        return iTestUserDao.queryOne2One(param);
    }


    @Override
    public List<TestUserDTO> queryOne2Many(Map<String, Object> param) {
        // TODO Auto-generated method stub
        return iTestUserDao.queryOne2Many(param);
    }


    @Override
    public List<TestMobileDTO> queryMany2One(Map<String, Object> param) {
        // TODO Auto-generated method stub
        return iTestUserDao.queryMany2One(param);
    }


    @Override
    public List<TestUserDTO> queryMany2Many1(Map<String, Object> param) {
        // TODO Auto-generated method stub
        return iTestUserDao.queryMany2Many1(param);
    }


    @Override
    public List<TestUserDTO> queryMany2Many2(Map<String, Object> param) {
        // TODO Auto-generated method stub
        return iTestUserDao.queryMany2Many2(param);
    }







}
