/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.example.stream;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author shihong.msh
 * @version $Id: FilterDemo.java, v 0.1 2018年12月27日 5:31 PM shihong.msh Exp $
 */
public class FilterDemo {

    private static List<String> param1 = Arrays.asList("a","b","v");


    public static void main(String[] args) {

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(new Long("1546444800000"));
        System.out.print(c.getTime());


        System.out.println(param1.contains("v"));
        System.out.println(param1.contains("c"));

        List<String> list = null;
        list.forEach(str -> {
            System.out.println(param1.contains("c"));
        });

        test1();

    }



    private static void test1(){


    }
}