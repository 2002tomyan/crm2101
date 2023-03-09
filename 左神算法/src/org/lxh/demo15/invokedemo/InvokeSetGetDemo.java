package org.lxh.demo15.invokedemo;

import java.lang.reflect.Method;

public class InvokeSetGetDemo {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("org.lxh.demo15.Person");
            Object obj = c1.newInstance();

            setter(obj,"name","李兴华",String.class);
            setter(obj,"age",30,int.class);
            getter(obj,"name");
            getter(obj,"age");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void setter(Object obj,String att,Object value,Class<?> type){
        try {
            Method met = obj.getClass().getMethod("set" + initStr(att), type);
            met.invoke(obj,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getter(Object obj,String att){
        try {
            Method met = obj.getClass().getMethod("get" + initStr(att));
            System.out.println(met.invoke(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String initStr(String old){
        return old.substring(0,1).toUpperCase() + old.substring(1);
    }
}
