package com.example.json;

import java.util.List;

public class AImpl implements  A{
    @Override
    public void AA(List<String> list) {
        System.out.println("list1:"+ list);
        list.add("fi anl ");
        System.out.println("list2:"+ list);
    }

    @Override
    public void AA(String list) {
        System.out.println("list1:"+ list);
        list = "fi nal ";
        System.out.println("list2:"+ list);
    }
}
