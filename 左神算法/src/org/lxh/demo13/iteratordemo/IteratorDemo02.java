package org.lxh.demo13.iteratordemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo02 {
    public static void main(String[] args) {
        List<String> all = new ArrayList<>();
        all.add("hello");
        all.add("_");
        all.add("world");
        Iterator<String> iterator = all.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if("_".equals(str)){
                iterator.remove();
            }else {
                System.out.print(str+"、");
            }
        }
        System.out.println("\n"+all);
    }
}
