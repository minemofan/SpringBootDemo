package com.example.json;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class FastJsonTest {


    public static void main(String[] args) {

        Date date = new Date();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(new Date().before(date));
        System.out.println(new Date().after(date));

        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        Set<String> list2 = new HashSet<>();
        list2.add("1");
        list2.add("2");

        System.out.println(list1.containsAll(list2));

        System.out.println(list2.containsAll(list1));

/*
        OptionDTO optionDTO = new OptionDTO();
        optionDTO.setOptionCode("1");
        optionDTO.setOptionDesc("选项1描述");

        OptionDTO optionDTO2 = new OptionDTO();
        optionDTO2.setOptionCode("2");
        optionDTO2.setOptionDesc("选项2描述");

        OptionDTO optionDTO3 = new OptionDTO();
        optionDTO3.setOptionCode("3");
        optionDTO3.setOptionDesc("选项3描述");

        List list = Lists.newArrayList();
        list.add(optionDTO);
        list.add(optionDTO2);
        list.add(optionDTO3);

        System.out.println(JSON.toJSONString(list));

        List<String> lists = Lists.newArrayList();
        lists.add("1");
        lists.add("2");
        lists.add("3");

        System.out.println(JSON.toJSONString(lists));

        String idStr = Joiner.on("','").join(lists);

        idStr = "'" + idStr + "'";
        System.out.println("idStr:"+ idStr);

        List<String> list222 = null;
        System.out.println(list222.size() > 0);
*/
    }




    public void test1(){
        TestDto testDao = new TestDto();
        testDao.setId(123);
        testDao.setName("name2");



        String str = JSON.toJSONString(testDao) ;

        System.out.println(str);



        TestDto obj = JSON.parseObject(str, TestDto.class);

        System.out.println(obj.getName());



        String str2 = JSON.toJSONString(null) ;

        System.out.println("str2:"+ str2);


        List<TestDto> testDtoList = new ArrayList<TestDto>();
        testDtoList.add(testDao);
        String str3 = JSON.toJSONString(testDtoList) ;
        System.out.println(str3);


        List<TestDto> testDtoList3 = JSON.parseArray(str3, TestDto.class);
        System.out.println(testDtoList3);
    }

}
