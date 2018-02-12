package com.core.dao.impl;

import com.core.dao.ITestUserDaoByIndex;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestUserDaoByIndexImpl implements ITestUserDaoByIndex {



    @Override
    public String getNameTMock(String id) {
        return "name" + id;
    }

    @Override
    public List<String> getListTMock(String name) {
        List<String> list = new ArrayList<String>();
        list.add("demoDao"+ name + "1");
        list.add("demoDao"+ name + "2");
        list.add("demoDao"+ name + "3");
        list.add("demoDao"+ name + "4");
        list.add("demoDao"+ name + "5");
        return list;
    }
}
