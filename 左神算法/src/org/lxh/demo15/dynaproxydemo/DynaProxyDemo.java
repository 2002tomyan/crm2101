package org.lxh.demo15.dynaproxydemo;

public class DynaProxyDemo {
    public static void main(String[] args) {
        MyInvocationHandler  handler = new MyInvocationHandler();
        Subject sub = (Subject) handler.bind(new RealSubject());
        String info = sub.say("李兴华", 30);
        System.out.println(info);
    }
}
