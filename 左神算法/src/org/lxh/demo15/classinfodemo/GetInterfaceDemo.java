package org.lxh.demo15.classinfodemo;

public class GetInterfaceDemo {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("org.lxh.demo15.Person");
            Class<?>[] c1 = c.getInterfaces();
            for (int i = 0; i < c1.length; i++) {
                System.out.println(c1[i].getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
