/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.example.tree;

/**
 *
 * @author shihong.msh
 * @version $Id: TreeDemo.java, v 0.1 2018年12月06日 12:12 PM shihong.msh Exp $
 */
public class TreeDemo {

    public static void main(String[] args) {
        BinaryTreeManger binaryTreeManger = new BinaryTreeManger();
        binaryTreeManger.add(3);
        binaryTreeManger.add(1);
        binaryTreeManger.add(4);
        binaryTreeManger.add(8);
        binaryTreeManger.add(6);
        binaryTreeManger.print();

        System.out.println("\n------------------------------------");
    }
}