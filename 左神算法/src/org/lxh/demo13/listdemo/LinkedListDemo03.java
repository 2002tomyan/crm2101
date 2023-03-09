package org.lxh.demo13.listdemo;

import java.util.LinkedList;

public class LinkedListDemo03 {
    public static void main(String[] args) {
        LinkedList<String> link = new LinkedList<>();
        link.add("A");
        link.add("B");
        link.add("C");
        System.out.print("以FIFO的方式输出：");
        for (int i = 0; i < link.size()+2; i++) {
            System.out.print(link.poll()+"、");
        }
    }
}
