package org.lxh.demo15.classinfodemo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GetFieldDemo {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("org.lxh.demo15.Person");
            //获得本类属性
            Field[] f = c1.getDeclaredFields();
            for (int i = 0; i < f.length; i++) {
                //取得属性的类型
                Class<?> r = f[i].getType();
                //得到修饰符的数字
                int mo = f[i].getModifiers();
                //还原
                String priv = Modifier.toString(mo);
                System.out.print(priv+" ");
                System.out.print(r.getName()+" ");
                System.out.print(f[i].getName()+" ");
                System.out.println(";");
            }

            System.out.println("==================================================================");
            Field[] f1 = c1.getFields();
            for (int i = 0; i < f1.length; i++) {
                //取得属性类型
                Class<?> r1 = f1[i].getType();
                //取得修饰符当中的数字
                int mo1 = f1[i].getModifiers();
                //通过toString方法还原
                String priv1 = Modifier.toString(mo1);
                System.out.print(priv1+" ");
                System.out.print(r1.getName()+" ");
                System.out.print(f1[i].getName()+" ");
                System.out.println(";");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
