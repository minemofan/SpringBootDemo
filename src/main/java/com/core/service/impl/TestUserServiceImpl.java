package com.core.service.impl;

import com.core.dao.IDemoDaoUnTran;
import com.core.dao.impl.DemoDaoImpl;
import com.core.dao.mapper.ITestUserMapper;
import com.core.service.ITestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestUserServiceImpl implements ITestUserService{

   // @Autowired
    private DemoDaoImpl iDemoDao;

  //  @Autowired
    private ITestUserMapper iTestUserMapper;

    @Autowired
    private IDemoDaoUnTran iDemoDaoUnTran;


    @Override
    public String getNameTMock(String id) {
        id = "service" + id;
        return iDemoDaoUnTran.getNameTMock(id);
    }

    @Override
    public List<String> getListTMock(String name) {
        name = "serviceToId" + name;
        String rstr = iDemoDaoUnTran.getNameTMock(name);
        return iDemoDaoUnTran.getListTMock(rstr);
    }
}
