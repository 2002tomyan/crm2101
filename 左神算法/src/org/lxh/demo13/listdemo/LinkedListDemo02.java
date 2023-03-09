package org.lxh.demo13.listdemo;

import java.util.LinkedList;

public class LinkedListDemo02 {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<>();
        link.add("A");
        link.add("B");
        link.add("C");
        System.out.println(link.element());
        System.out.println(link);
        System.out.println(link.peek());
        System.out.println(link);
        System.out.println(link.poll());
        System.out.println(link);
    }
}

