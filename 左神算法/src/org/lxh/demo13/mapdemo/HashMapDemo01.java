package org.lxh.demo13.mapdemo;

import java.util.*;

public class HashMapDemo01 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("mldn","www,midn.com");
        map.put("zhinangtuan","www.zhinangtuan.com.net");
        map.put("mldnjava","www.mldnjava.com.cn");
//        Set<String> keys = map.keySet();
        Collection<String> values = map.values();
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.print(str+"、");
        }

    }
}
