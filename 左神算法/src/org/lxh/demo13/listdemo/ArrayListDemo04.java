package org.lxh.demo13.listdemo;

import java.util.ArrayList;
import java.util.List;

//将集合变为对象数组
public class ArrayListDemo04 {
    public static void main(String[] args) {
        List<String> allList = new ArrayList<>();
        allList.add("Hello");
        allList.add(0,"World");
        allList.add("MLDN");
        allList.add("www.baidu.com");

        String[] str = allList.toArray(new String[]{});
        System.out.print("指定数组类型：");
        for (int i = 0; i < str.length;i++){
            System.out.print(str[i] + "、");
        }
        System.out.print("\n返回对象数组：");
        Object[] obj = allList.toArray();
        for(int i = 0;i<obj.length;i++){
            String temp = (String) obj[i];
            System.out.print(temp+"、");
        }

    }
}
