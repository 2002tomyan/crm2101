package org.lxh.demo15.classinfodemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
//获得全部的构造方法
public class GetConstructorDemo02 {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("org.lxh.demo15.Person");
            Constructor<?>[] con = c1.getConstructors();
            for (int i = 0; i < con.length; i++) {
                //列出构造中的参数类型
                Class<?>[] p = con[i].getParameterTypes();
                //取出权限
//                System.out.print(con[i].getModifiers()+" ");
                int mo = con[i].getModifiers();
                //还原权限
                System.out.print(Modifier.toString(mo)+" ");
                //输出构造方法名称
                System.out.print(con[i].getName());
                System.out.print("(");
                for (int j = 0; j < p.length; j++) {
                    //打印类型参数
                    System.out.print(p[j].getName()+" arg"+i);
                    if(j < p.length-1){
                        System.out.print("、");
                    }
                }
                System.out.println("){}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
