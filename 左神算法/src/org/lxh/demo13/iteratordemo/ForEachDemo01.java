package org.lxh.demo13.iteratordemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachDemo01 {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        all.add("hello");
        all.add("_");
        all.add("world");
        for(String str : all){
            System.out.print(str+"、");
        }
    }
}
