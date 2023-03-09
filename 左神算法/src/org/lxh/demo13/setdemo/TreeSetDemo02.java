package org.lxh.demo13.setdemo;

import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //通过年龄进行比较
    @Override
    public int compareTo(Person per) {
        if(this.age > per.age)
            return 1;
        else if(this.age < per.age)
            return -1;
        else
            return this.name.compareTo(per.name);//增加字符串的比较
    }
}


public class TreeSetDemo02 {
    public static void main(String[] args) {
        Set<Person> allSet = new TreeSet<Person>();
        allSet.add(new Person("张三",30));
        allSet.add(new Person("李四",31));
        allSet.add(new Person("王五",32));
        allSet.add(new Person("王五",32));
        allSet.add(new Person("王五",32));
        allSet.add(new Person("赵六",33));
        allSet.add(new Person("孙七",33));
        System.out.println(allSet);
    }
}
