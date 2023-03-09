package org.lxh.demo15.getclassdemo;

class X1{

}

public class GetClassDemo02 {
    public static void main(String[] args) {
        Class<?> c1 = null;
        Class<?> c2 = null;
        Class<?> c3 = null;

        try {
            c1 = Class.forName("org.lxh.demo15.getclassdemo.X1");
        } catch (Exception e) {
           e.printStackTrace();
        }

        c2 = new X1().getClass();
        c3 = X.class;
        System.out.println("类名称："+c1.getName());
        System.out.println(c2.getName());
        System.out.println(c3.getName());
    }
}
