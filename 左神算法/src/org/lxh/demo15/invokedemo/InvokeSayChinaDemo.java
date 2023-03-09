package org.lxh.demo15.invokedemo;

import java.lang.reflect.Method;

public class InvokeSayChinaDemo {
    public static void main(String[] args) {
        try {
            //声明并实例化
            Class<?> c1 = Class.forName("org.lxh.demo15.Person");
            Method met = c1.getMethod("sayChina");
            met.invoke(c1.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
