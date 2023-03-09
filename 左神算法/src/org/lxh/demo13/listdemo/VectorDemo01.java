package org.lxh.demo13.listdemo;

import java.util.List;
import java.util.Vector;

public class VectorDemo01 {
    public static void main(String[] args) {
        List<String> allList = new Vector<>();
        allList.add("Hello");
        allList.add(0,"World");
        allList.add("MLDN");
        allList.add("www.baidu.com");

        for (int i = 0; i < allList.size(); i++) {
            System.out.print(allList.get(i)+"、");
        }
    }
}
