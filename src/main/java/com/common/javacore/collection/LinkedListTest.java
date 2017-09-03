package com.common.javacore.collection;

import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");

        System.out.println("链表的第一个元素是 : " + linkedList.getFirst());
        System.out.println("链表最后一个元素是 : " + linkedList.getLast());

        linkedList.add("6");
        System.out.println("linkedList-1:"+ linkedList.toString());

        /*
        try {
            linkedList.wait(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        String i = linkedList.remove(2);
        System.out.println("linkedList-2-1:"+ i);
        System.out.println("linkedList-2:"+ linkedList.toString());

//        linkedList.notify();
   //     System.out.println("linkedList-3:"+ linkedList.toString());
    }

}
