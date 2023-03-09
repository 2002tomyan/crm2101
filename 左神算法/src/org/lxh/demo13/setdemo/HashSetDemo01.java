package org.lxh.demo13.setdemo;

import java.util.HashSet;
import java.util.Set;

//散列的存放
public class HashSetDemo01 {
    public static void main(String[] args) {
        Set<String> allSet = new HashSet<>();
        allSet.add("A");
        allSet.add("B");
        allSet.add("C");
//        allSet.add("C");
//        allSet.add("C");
        allSet.add("D");
        allSet.add("E");
        System.out.println(allSet);
    }
}
