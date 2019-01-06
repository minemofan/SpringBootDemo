/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.example.tree;

/**
 *
 * @author shihong.msh
 * @version $Id: BinaryTreeManger.java, v 0.1 2018年12月06日 12:19 PM shihong.msh Exp $
 */
public class BinaryTreeManger {

    private Node root;

    //根节点
    public void add(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            root.addNode(data);
        }
    }

    public void print() {
        root.print();
    }
}