/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.example.linked;

/**
 *
 * @author shihong.msh
 * @version $Id: NodeManager.java, v 0.1 2018年12月05日 5:04 PM shihong.msh Exp $
 */
public class NodeManager {

    private Node root;//根节点

    // 添加节点
    public void addNode(String data) {
        if (root == null) {
            root = new Node(data);
        } else {
            root.addNode(data);
        }
    }

    //删除节点
    public void delNode (String data) {
        if (root.getData().equals(data)){
            root = root.getNext();
        } else {
            root.delNode(data);
        }
    }

    //打印节点
    public void print() {
        if (root != null) {
            System.out.print(root.getData() + "->>");
            root.print();
        }
    }
}