package com.core.service.impl;

import com.core.dao.impl.DemoDaoImpl;
import com.core.dao.mapper.ITestUserMapper;
import com.core.service.ITestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestUserServiceImpl implements ITestUserService{

    @Autowired
    private DemoDaoImpl iDemoDao;

    @Autowired
    private ITestUserMapper iTestUserMapper;



}
