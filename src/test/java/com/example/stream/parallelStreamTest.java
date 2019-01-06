/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.example.stream;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author shihong.msh
 * @version $Id: parallelStreamDEMO.java, v 0.1 2018年12月27日 6:21 PM shihong.msh Exp $
 */
public class parallelStreamTest {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        for(int i=0; i <= 10 ;i++){
            list.add(String.valueOf(i));
        }
        System.out.println(list);

        List<String> list2 = list.parallelStream().map(s -> s = s + "a").collect(Collectors.toList());

        System.out.println(list2);
    }
}