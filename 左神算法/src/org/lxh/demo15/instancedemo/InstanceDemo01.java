package org.lxh.demo15.instancedemo;

import java.lang.reflect.Constructor;

class Person{
    private String name;
    private int age;

//    public Person() {
//    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class InstanceDemo01 {
    public static void main(String[] args) {
        //有参的
//        Class<?> c = null;
//        try {
//            c = Class.forName("org.lxh.demo15.instancedemo.Person");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Person per = null;
//        try {
//            per = (Person) c.newInstance();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        per.setName("李兴华");
//        per.setAge(30);
//        System.out.println(per);

        try {
            Class<?> c = Class.forName("org.lxh.demo15.instancedemo.Person");
            Constructor<?>[] cons = c.getConstructors();
            Person per = (Person) cons[0].newInstance("李兴华", 30);
            System.out.println(per);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
