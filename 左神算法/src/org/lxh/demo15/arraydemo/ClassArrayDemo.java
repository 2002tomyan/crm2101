package org.lxh.demo15.arraydemo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ClassArrayDemo {
    public static void main(String[] args) {
        int[] temp = {1,2,3};
        Class<?> c = temp.getClass().getComponentType();
        System.out.println(c.getName());
        System.out.println(Array.getLength(temp));
        System.out.println(Array.get(temp,0));
        Array.set(temp,0,6);
        System.out.println(Array.get(temp,0));
    }
}
