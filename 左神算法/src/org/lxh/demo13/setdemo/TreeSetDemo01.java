package org.lxh.demo13.setdemo;

import java.util.Set;
import java.util.TreeSet;

//有序的存放
public class TreeSetDemo01 {
    public static void main(String[] args) {
        Set<String> allSet = new TreeSet<>();
        allSet.add("A");
        allSet.add("B");
        allSet.add("C");
        allSet.add("C");
        allSet.add("C");
        allSet.add("D");
        allSet.add("E");
        System.out.println(allSet);
    }
}
