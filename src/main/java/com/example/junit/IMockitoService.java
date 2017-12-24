package com.example.junit;

import java.util.List;

public interface IMockitoService {

    public String getName(String id);

    public List<String> getList(String name);

    public boolean verifys(String id);
}
