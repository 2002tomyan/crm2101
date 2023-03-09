package org.lxh.demo13.listdemo;

import java.util.ArrayList;
import java.util.List;

//输出全部信息
public class ArrayListDemo03 {
    public static void main(String[] args) {
        List<String> allList = new ArrayList<>();
        allList.add("Hello");
        allList.add(0,"World");
        allList.add("MLDN");
        allList.add("www.baidu.com");

        System.out.print("由前向后输出：");
        for(int i = 0; i < allList.size();i++){
            System.out.print(allList.get(i)+"、");
        }

        System.out.print("\n由后向前输出：");
        for(int i = allList.size()-1;i >= 0; i--){
            System.out.print(allList.get(i)+"、");
        }
    }
}
