package org.lxh.demo13.iteratordemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IteratorDemo03 {
    public static void main(String[] args) {
        //Iterator输出Map实例
//        Map<String,String> map = new HashMap<>();
//
//        map.put("mldn","www.mldn.com");
//        map.put("zhong","www.zhong.com.cn");
//        map.put("mldnjava","www.mldnjava.com");
//        Set<Map.Entry<String, String>> allSet = map.entrySet();
//        Iterator<Map.Entry<String, String>> iter = allSet.iterator();
//        while (iter.hasNext()){
//            Map.Entry<String, String> me = iter.next();
//            System.out.println(me.getKey()+"--->"+me.getValue());
//        }
        //foreach输出Map
        Map<String,String> map = new HashMap<>();

        map.put("mldn","www.mldn.com");
        map.put("zhong","www.zhong.com.cn");
        map.put("mldnjava","www.mldnjava.com");
        for (Map.Entry<String, String> me : map.entrySet()) {
            System.out.println(me.getKey()+"-->"+me.getValue());
        }
    }
}
