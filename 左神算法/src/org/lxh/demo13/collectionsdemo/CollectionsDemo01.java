package org.lxh.demo13.collectionsdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionsDemo01 {
    public static void main(String[] args) {
        //增加内容
//        List<String> all = new ArrayList<>();
//        Collections.addAll(all,"MLDN","LXH","mldnjava");
//        Iterator<String> iterator = all.iterator();
//        while (iterator.hasNext()){
//            String str = iterator.next();
//            System.out.print(str+"、");
//        }
        //反转内容
//        List<String> all = new ArrayList<>();
//        Collections.addAll(all,"MLDN","LXH","mldnjava");
//        Collections.reverse(all);
//        Iterator<String> iterator = all.iterator();
//        while (iterator.hasNext()){
//            String str = iterator.next();
//            System.out.print(str+"、");
//        }
        //检索内容
//        List<String> all = new ArrayList<>();
//        Collections.addAll(all,"MLDN","LXH","mldnjava");
//        int point = Collections.binarySearch(all, "LXH");
//        System.out.println(point);
//        point = Collections.binarySearch(all,"L1");
//        System.out.println(point);

        //交换内容
//        List<String> all = new ArrayList<>();
//        Collections.addAll(all,"MLDN","LXH","mldnjava");
//        if (Collections.replaceAll(all,"LXH","李兴华")) {
//            System.out.println("替换之后的结果");
//        }
//        Iterator<String> iterator = all.iterator();
//        while (iterator.hasNext()){
//            String str = iterator.next();
//            System.out.print(str+"、");
//        }
        //集合排序
//        List<String> all = new ArrayList<>();
//        Collections.addAll(all,"1、MLDN","2、LXH","3、mldnjava");
//        Collections.addAll(all,"B、www.mldn.com");
//
//        Collections.addAll(all,"A、www.mldnjava.com");
//        Iterator<String> iterator = all.iterator();
//        while (iterator.hasNext()){
//            String str = iterator.next();
//            System.out.print(str+"、");
//        }
//        Collections.sort(all);
//        System.out.println();;
//        Iterator<String> iterator1 = all.iterator();
//        while (iterator1.hasNext()){
//            String str = iterator1.next();
//            System.out.print(str+"、");
//        }

        //交换位置的内容
        List<String> all = new ArrayList<>();
        Collections.addAll(all,"1、MLDN","2、LXH","3、mldnjava");

        Iterator<String> iterator = all.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.print(str+"、");
        }

        Collections.swap(all,0,2);
        System.out.println();
        iterator = all.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"、");
        }
    }
}
