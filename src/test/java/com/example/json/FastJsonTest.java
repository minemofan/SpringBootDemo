package com.example.json;

import com.alibaba.fastjson.JSON;

public class FastJsonTest {


    public static void main(String[] args) {

        TestDto testDao = new TestDto();
        testDao.setId(123);
        testDao.setName("name2");


        String str = JSON.toJSONString(testDao) ;

        System.out.println(str);



        TestDto obj = JSON.parseObject(str, TestDto.class);

        System.out.println(obj.getName());

    }


}
