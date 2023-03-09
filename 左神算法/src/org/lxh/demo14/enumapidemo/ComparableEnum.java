package org.lxh.demo14.enumapidemo;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

enum Color2{
    RED,GREEN,BLUE;
}
public class ComparableEnum {
    public static void main(String[] args) {
        Set<Color2> t = new TreeSet<>();
        t.add(Color2.GREEN);
        t.add(Color2.BLUE);
        t.add(Color2.RED);

        Iterator<Color2> iterator = t.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"、");
        }
    }
}
