package com.example.junit;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class MockitoDaoImpl implements IMockioDao{

    private Logger LOGGER = LoggerFactory.getLogger(MockitoDaoImpl.class);

    @Override
    public String getName(String id)  {
        return ",daoName" + id;
    }

    @Override
    public List<String> getList(String name) {
        List<String> list = new ArrayList<String>();

        list.add(",daoList"+ name + "1");
        list.add(",daoList"+ name + "2");
        list.add(",daoList"+ name + "3");
        list.add(",daoList"+ name + "4");
        list.add(",daoList"+ name + "5");
        return list;
    }

    @Override
    public String getNames(String id) {
        return ",daoNames" + id;
    }
}
