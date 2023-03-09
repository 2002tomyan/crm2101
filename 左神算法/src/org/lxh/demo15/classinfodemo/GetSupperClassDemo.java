package org.lxh.demo15.classinfodemo;

//获取Person的父类
public class GetSupperClassDemo {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("org.lxh.demo15.Person");
            Class<?> c = c1.getSuperclass();
            System.out.println(c.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
