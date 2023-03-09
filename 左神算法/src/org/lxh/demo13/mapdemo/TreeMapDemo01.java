package org.lxh.demo13.mapdemo;

import java.util.*;

public class TreeMapDemo01 {
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<>();
        map.put("A","www,midn.com");
        map.put("C","www.zhinangtuan.com.net");
        map.put("B","www.mldnjava.com.cn");

        Set<String> keys = map.keySet();
        Iterator<String> iter = keys.iterator();

        while (iter.hasNext()){
            String str = iter.next();
            System.out.println(str+"--->"+map.get(str));
        }
    }
}
