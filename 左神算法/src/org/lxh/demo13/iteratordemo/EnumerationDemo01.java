package org.lxh.demo13.iteratordemo;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo01 {
    public static void main(String[] args) {
        Vector<String> all = new Vector<>();
        all.add("hello");
        all.add("_");
        all.add("world");
        Enumeration<String> enu = all.elements();
        while (enu.hasMoreElements()){
            System.out.print(enu.nextElement()+"、");
        }
    }
}
