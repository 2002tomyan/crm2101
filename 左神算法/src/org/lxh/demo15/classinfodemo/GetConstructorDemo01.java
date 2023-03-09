package org.lxh.demo15.classinfodemo;

import java.lang.reflect.Constructor;

//获得全部的构造方法
public class GetConstructorDemo01 {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("org.lxh.demo15.Person");
            Constructor<?>[] con = c1.getConstructors();
            for (int i = 0; i < con.length; i++) {
                System.out.println(con[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
