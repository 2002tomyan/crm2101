package org.lxh.demo13.mapdemo;

import java.util.*;

class Person{
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "姓名："+this.name+"; 年龄："+this.age;
    }

    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if(!(obj instanceof Person))
            return false;

        Person p = (Person) obj;
        if(this.name.equals(p.name) && this.age == p.age){
            return true;
        }else {
            return false;
        }
    }

    public int hashCode(){
        return this.name.hashCode()*this.age;
    }

}

public class HashMapDemo02 {
    public static void main(String[] args) {
        //String --> Person的映射
//        Map<String,Person> map = new HashMap<>();
//        map.put("zhang",new Person("张三",21));
//        System.out.println(map.get("zhang"));
        //Person --> String的映射。（1.采用实例化对象）（2.如果采用匿名对象的话，要采用hashCode()和equals()的帮助。）
        //匿名对象和实例化对象。
//            Map<Person,String> map = new HashMap<>();
//            Person person = new Person("张三",20);
//        map.put(person,"zhangsan");
//        System.out.println(map.get(person));

//        Map<Person,String> map = new HashMap<>();
//        map.put(new Person("张三",20),"zhang");
//        map.put(new Person("张三",20),"zhang_2");
//        map.put(new Person("李四",21),"lisi");
//
//        Set<Map.Entry<Person, String>> allSet = map.entrySet();
//        Iterator<Map.Entry<Person, String>> iter = allSet.iterator();
//        while (iter.hasNext()){
//            Map.Entry<Person, String> str = iter.next();
//            System.out.println(str.getKey()+"-->"+str.getValue());
//        }
        Map<Person,String> map = new IdentityHashMap<>();
        map.put(new Person("张三",20),"zhang");
        map.put(new Person("张三",20),"zhang_2");
        map.put(new Person("李四",21),"lisi");

        Set<Map.Entry<Person, String>> allSet = map.entrySet();
        Iterator<Map.Entry<Person, String>> iter = allSet.iterator();
        while (iter.hasNext()){
            Map.Entry<Person, String> str = iter.next();
            System.out.println(str.getKey()+"-->"+str.getValue());
        }

    }
}
