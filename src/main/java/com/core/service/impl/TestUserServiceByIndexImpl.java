package com.core.service.impl;

import com.core.dao.ITestUserDaoByIndex;
import com.core.service.ITestUserServiceByIndex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestUserServiceByIndexImpl implements ITestUserServiceByIndex{

    protected static Logger _logger = LoggerFactory.getLogger(TestUserServiceByIndexImpl.class);

    @Autowired
    private ITestUserDaoByIndex iTestUserDaoByIndex;

    @Override
    public String getNameTMock(String id) {
        id = "service" + id;
        return iTestUserDaoByIndex.getNameTMock(id);
    }

    @Override
    public List<String> getListTMock(String name) {
        name = "serviceToId" + name;
        String rstr = iTestUserDaoByIndex.getNameTMock(name);
        return iTestUserDaoByIndex.getListTMock(rstr);
    }
}
