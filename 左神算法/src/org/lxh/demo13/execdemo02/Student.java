package org.lxh.demo13.execdemo02;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private List<Course> allCourses;

    public Student(){
        this.allCourses = new ArrayList<>();
    }

    public Student(String name,int age){
        this();
        this.setName(name);
        this.setAge(age);

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

    public List<Course> getAllCourses() {
        return allCourses;
    }

    public void setAllCourses(List<Course> allCourses) {
        this.allCourses = allCourses;
    }

    public String toString(){
        return "学生姓名："+this.name+"; 年龄："+this.age;
    }
}
