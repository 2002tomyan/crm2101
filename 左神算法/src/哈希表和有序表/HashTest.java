package 哈希表和有序表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class HashTest {
    public static void main(String[] args) {

//        HashMap<Integer,String> hashMap = new HashMap<>();
//        hashMap.put(1,"我是1");
//        hashMap.put(2,"我是2");
//        hashMap.put(3,"我是3");
//
//        System.out.println(hashMap.containsKey(1));
//        System.out.println(hashMap.get(3));
//        System.out.println(hashMap.get(10));
//
//        hashMap.put(3,"它是3");
//        System.out.println(hashMap.get(3));
//
//        hashMap.remove(3);
//        System.out.println(hashMap.get(3));
//
//        //只有key，没有value
//        HashSet<String> set = new HashSet<>();
//        set.add("abc");
//        System.out.println(set.contains("abc"));
//
        int a = 10000;
        int b = 10000;
        System.out.println(a == b);

        System.out.println("==========================================================");
        Integer c = 1;
        Integer d = 1;
        System.out.println(c==d);
        System.out.println("==========================================================");

        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"我是1");
        treeMap.put(2,"我是2");
        treeMap.put(4,"我是4");
        treeMap.put(7,"我是7");
        treeMap.put(8,"我是8");
        treeMap.put(3,"我是3");

        System.out.println(treeMap.containsKey(4));
        System.out.println(treeMap.get(4));

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());

        //<=5 离5最近的
        System.out.println(treeMap.floorKey(5));
        //>=6 离6最近的
        System.out.println(treeMap.ceilingKey(6));
        //O(logN)

    }
}
