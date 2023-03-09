package org.lxh.demo15.invokedemo;

import java.lang.reflect.Method;

public class InvokeSayHelloDemo {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("org.lxh.demo15.Person");
            Method met = c1.getMethod("sayHello", String.class, int.class);
            String rv = null;
            rv = (String) met.invoke(c1.newInstance(), "李兴华", 20);
            System.out.println(rv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
