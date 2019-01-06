/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.example.linked;

/**
 *
 * @author shihong.msh
 * @version $Id: LinkedListDemo.java, v 0.1 2018年12月05日 5:03 PM shihong.msh Exp $
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        NodeManager nodeManager = new NodeManager();
        nodeManager.addNode("蚂");
        nodeManager.addNode("蚁");
        nodeManager.addNode("金");
        nodeManager.addNode("服");
        nodeManager.addNode("支");
        nodeManager.addNode("付");
        nodeManager.addNode("宝");
        nodeManager.delNode("！");
        nodeManager.print();

        System.out.println("\n------------------------------------");
        nodeManager.delNode("服");
        nodeManager.print();

    }
}