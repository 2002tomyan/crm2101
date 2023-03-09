package org.lxh.demo15.invokedemo;

import java.lang.reflect.Field;

public class InvokeFieldDemo {
    public static void main(String[] args) throws Exception {
        Class<?> c1 = Class.forName("org.lxh.demo15.Person");
        Object obj = c1.newInstance();
        Field nameField = c1.getDeclaredField("name");
        Field ageField = c1.getDeclaredField("age");
        nameField.setAccessible(true);
        nameField.set(obj,"李兴华");
        ageField.setAccessible(true);
        ageField.set(obj,30);

        System.out.println(nameField.get(obj));
        System.out.println(ageField.get(obj));
    }
}
