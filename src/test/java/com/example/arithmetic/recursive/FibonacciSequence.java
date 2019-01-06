/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.example.arithmetic.recursive;

import com.example.arithmetic.BasicArithmetic;

/**
 * F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）
 * @author shihong.msh
 * @version $Id: FibonacciSequence.java, v 0.1 2018年11月06日 5:39 PM shihong.msh Exp $
 */
public class FibonacciSequence extends BasicArithmetic{


    public static void main(String[] args) {
        sysLogLn("F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）");
        method1();
        sysLogLn("");
        method2();
        sysLogLn("");
        method3();
    }


    public static void method1(){
        sysLog("直接赋值法：");
        int num1 = 1, num2 = 2, num3 = 0;

        sysLog(num1);
        sysLog(num2);
        for (int i = 1; i < 8; i++) {
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            sysLog(num3);
        }
    }

    public static void method2(){
        sysLog("以数组形式递归：");
        int[] arr = new int[10];
        arr[1] = 1;
        arr[2] = 2;

        sysLog(arr[1]);
        sysLog(arr[2]);
        for(int i = 3; i < 10; i++){
            arr[i] = arr[i-1] + arr[i-2];
            sysLog(arr[i]);
        }
    }

    public static int count = 0;
    public static void method3(){
        sysLog("函数方式递归(循环起始标志："+ count +")：");
        for (int i = 1; i <=10; i++) {
            sysLog(method3Function(i));
        }
        sysLog("函数方式递归(共计循环次数："+ count+")：");
    }

    public static int method3Function(int n) {
        count ++;
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return method3Function(n - 1) + method3Function(n - 2);  //自己调用自己
        }
    }
}