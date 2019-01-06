/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.example.arithmetic;

/**
 *
 * @author shihong.msh
 * @version $Id: DeleteK.java, v 0.1 2018年11月06日 4:03 PM shihong.msh Exp $
 */
public class DeleteK {

    public static void main(String[] args) {

        //固定的常量(比数组元素的个数要大)
        int N = 8;

        int[] arrays = new int[N];

        //对数组进行初始化
        for (int i = 0; i < 8; i++) {
            arrays[i] = i;
        }


        //要删除下标
        int k = 3;

        for (int i = k; i < N - 1; i++) {
            arrays[i] = arrays[i + 1];
        }



        for(int i=0; i < arrays.length; i++){
            System.out.print("," + arrays[i]);
        }


    }
}