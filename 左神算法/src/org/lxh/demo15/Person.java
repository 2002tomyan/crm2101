package org.lxh.demo15;

interface China{
    public static final String NATIONAL = "China";
    public static final String AUTHOR = "李兴华";

    public void sayChina();
    public String sayHello(String name,int age);
}
public class Person implements China{
    private String name;
    private int age;

    public Person(){

    }

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
    public void sayChina() {
        System.out.println(AUTHOR+","+NATIONAL);
    }

    @Override
    public String sayHello(String name, int age) {
        return name+age;
    }
}
