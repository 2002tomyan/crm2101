package org.lxh.demo15.classinfodemo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetMethodDemo {
    public static void main(String[] args) {
        try {
            Class<?> c1 = Class.forName("org.lxh.demo15.Person");
            Method[] m = c1.getMethods();
            for (int i = 0; i < m.length; i++) {
                //获取所有方法的返回值类型
                Class<?> r = m[i].getReturnType();
                //获取全部方法的参数类型
                Class<?>[] p = m[i].getParameterTypes();
                //得到方法的修饰符
                int xx = m[i].getModifiers();
                //还原修饰符
                System.out.print(Modifier.toString(xx));
                System.out.print(r.getName()+" ");
                System.out.print(m[i].getName());
                System.out.print("(");
                for (int x = 0; x < p.length; x++) {
                    System.out.print(p[x].getName()+" "+"arg"+x);
                    if(x<p.length-1){
                        System.out.print(",");
                    }
                }
                Class<?>[] ex = m[i].getExceptionTypes();
                if(ex.length>0){
                    System.out.print(") throws ");
                }else {
                    System.out.print(")");
                }
                for (int j = 0; j < ex.length; j++) {
                    System.out.print(ex[j].getName());
                    if(j < ex.length-1){
                        System.out.print(",");
                    }
                }
                System.out.println();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
