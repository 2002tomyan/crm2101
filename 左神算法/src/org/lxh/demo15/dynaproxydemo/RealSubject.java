package org.lxh.demo15.dynaproxydemo;

public class RealSubject implements Subject{
    @Override
    public String say(String name, int age) {
        return "姓名：" + name + "; 年龄："+age;
    }
}
