/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.example.tree;

/**
 * 二叉树节点
 * @author shihong.msh
 * @version $Id: Node.java, v 0.1 2018年12月06日 12:13 PM shihong.msh Exp $
 */
public class Node {

    private int data;

    private Node left; //左子树

    private Node right; //右子树

    public Node(int data) {
        this.data = data;
    }

    //添加节点
    public void addNode(int data) {
        //首先判断大小，来决定将data放在那个子树上
        if (data > this.data){
            //当前数据较大，放在右子树
            if (this.right == null) {
                this.right = new Node(data);
            } else {
                this.right.addNode(data);
            }
        } else {
            //较小放在左子树上
            if (this.left == null) {
                this.left = new Node(data);
            } else {
                this.left.addNode(data);
            }
        }
    }

    //中序遍历 左 -> 根 -> 右
    public void print() {
        if (this.left != null) {
            this.left.print();
        }

        System.out.print(data);
        if (this.right != null) {
            this.right.print();
        }
    }

    /**
     * Getter method for property <tt>data</tt>.
     *
     * @return property value of data
     */
    public int getData() {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     *
     * @param data value to be assigned to property data
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * Getter method for property <tt>left</tt>.
     *
     * @return property value of left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * Setter method for property <tt>left</tt>.
     *
     * @param left value to be assigned to property left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * Getter method for property <tt>right</tt>.
     *
     * @return property value of right
     */
    public Node getRight() {
        return right;
    }

    /**
     * Setter method for property <tt>right</tt>.
     *
     * @param right value to be assigned to property right
     */
    public void setRight(Node right) {
        this.right = right;
    }
}