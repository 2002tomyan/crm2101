package org.lxh.demo15.getclassdemo;

class X{

}
//得到一个完整的“包.类”的名称
public class GetClassDemo01 {
    public static void main(String[] args) {
        X x = new X();
        System.out.println(x.getClass().getName());
    }
}
