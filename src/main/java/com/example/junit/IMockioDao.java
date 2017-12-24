package com.example.junit;

import java.util.List;

public interface IMockioDao {

    public String getName(String id);

    public List<String> getList(String name);

    public String getNames(String id);

}
