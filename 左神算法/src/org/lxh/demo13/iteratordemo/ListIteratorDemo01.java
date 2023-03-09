package org.lxh.demo13.iteratordemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo01 {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        all.add("hello");
        all.add("_");
        all.add("world");
        ListIterator<String> listIterator = all.listIterator();
        while (listIterator.hasNext()){
            System.out.print(listIterator.next()+"、");
        }
        System.out.println();
        listIterator.add("LXH");
        while (listIterator.hasPrevious()){
            String str = listIterator.previous();
            System.out.print(str+"、");
        }
    }
}
