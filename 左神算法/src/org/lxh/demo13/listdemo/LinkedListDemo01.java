package org.lxh.demo13.listdemo;

import java.util.LinkedList;

public class LinkedListDemo01 {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<>();
        link.add("A");
        link.add("B");
        link.add("C");
        link.add("D");
        System.out.println("初始化链表："+link);
        link.addFirst("X");
        link.addLast("Y");
        System.out.println("增加头和尾之后的链表"+link);
    }
}
