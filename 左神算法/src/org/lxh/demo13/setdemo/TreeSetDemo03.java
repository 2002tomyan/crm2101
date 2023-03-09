package org.lxh.demo13.setdemo;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo03 {
    public static void main(String[] args) {
        SortedSet<String> allSet = new TreeSet<>();
        allSet.add("A");
        allSet.add("B");
        allSet.add("C");
        allSet.add("C");
        allSet.add("C");
        allSet.add("D");
        allSet.add("E");
        System.out.println("第一个元素："+allSet.first());
        System.out.println("最后一个元素："+allSet.last());
        System.out.println("headSet元素"+allSet.headSet("C"));
        System.out.println("tailSet元素"+allSet.tailSet("C"));
        System.out.println("subSet元素"+allSet.subSet("B","D"));
    }
}
