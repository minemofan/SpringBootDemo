/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.example.atomic;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author shihong.msh
 * @version $Id: IntegeTest.java, v 0.1 2018年12月26日 10:32 AM shihong.msh Exp $
 */
public class IntegeTest {

    public static void main(String[] args) {

        AtomicInteger actualIntegral = new AtomicInteger(0);

        List<Integer> list = Lists.newArrayList();
        list.add(new Integer("1"));
        list.add(new Integer("2"));
        list.add(new Integer("3"));
        list.add(new Integer("4"));
        list.add(new Integer("5"));

        System.out.println("actualIntegral 1:"+ actualIntegral);

        list.forEach(arr -> {

            actualIntegral.getAndAdd(arr);
        });

        System.out.println("actualIntegral 2:"+ actualIntegral);


        list = null;
        System.out.println("actualIntegral 3:"+ list.stream().map(num -> num.intValue()));

    }
}