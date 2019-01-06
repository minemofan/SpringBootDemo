/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.example.linked;

/**
 * 节点
 * @author shihong.msh
 * @version $Id: Node.java, v 0.1 2018年12月05日 5:07 PM shihong.msh Exp $
 */
public class Node {

    private String data;

    private Node next;

    public Node(String data) {
        this.data = data;
    }

    //添加方法
    public void addNode(String data) {
        if (this.next == null) {
            this.next = new Node(data);
        } else {
            this.next.addNode(data);
        }
    }

    //删除方法
    public void delNode(String name) {
        if (this.next != null) {
            if (this.next.data.equals(name)) {
                //将A的下一个节点指针，指向C，B会被回收
                this.next = this.next.next;
            } else {
                this.next.delNode(name);
            }
        }
    }

    //打印方法
    public void print() {
        if (this.next != null) {
            System.out.print(this.next.data + "->");
            this.next.print();
        }
    }

    /**
     * Getter method for property <tt>data</tt>.
     *
     * @return property value of data
     */
    public String getData() {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     *
     * @param data value to be assigned to property data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Getter method for property <tt>next</tt>.
     *
     * @return property value of next
     */
    public Node getNext() {
        return next;
    }

    /**
     * Setter method for property <tt>next</tt>.
     *
     * @param next value to be assigned to property next
     */
    public void setNext(Node next) {
        this.next = next;
    }
}