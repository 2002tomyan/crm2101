package org.lxh.demo13.listdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//添加对象
public class ArrayListDemo01 {
    public static void main(String[] args) {
        //list接口下的子类ArrayList
        List<String> allList = new ArrayList<String>();
        allList.add("Hello");
        allList.add(0,"World");
        System.out.println(allList);

        Collection<String> allCollection = new ArrayList<String>();
        allCollection.add("LXH");
        allCollection.add("www.baidu.com");
        allList.addAll(allCollection);
        allList.addAll(0,allCollection);

        System.out.println(allList);



    }
}
