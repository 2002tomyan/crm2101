package org.lxh.demo13.listdemo;

import java.util.ArrayList;
import java.util.List;

//删除对象
public class ArrayListDemo02 {
    public static void main(String[] args) {
        List<String> allList = new ArrayList<>();
        allList.add("Hello");
        allList.add(0,"World");
        allList.add("MLDN");
        allList.add("www.baidu.com");
        allList.remove(0);
        allList.remove("Hello");
        System.out.println(allList);
    }
}
