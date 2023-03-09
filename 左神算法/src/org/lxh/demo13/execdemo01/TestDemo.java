package org.lxh.demo13.execdemo01;

import java.util.Iterator;

public class TestDemo {
    public static void main(String[] args) {
        School sch = new School("清华大学");
        Student s1 = new Student("张三", 21);
        Student s2 = new Student("李四", 22);
        Student s3 = new Student("王五", 23);

        sch.getAllStudents().add(s1);
        sch.getAllStudents().add(s2);
        sch.getAllStudents().add(s3);

        s1.setSchool(sch);
        s2.setSchool(sch);
        s3.setSchool(sch);

        System.out.println(sch);

        Iterator<Student> iterator = sch.getAllStudents().iterator();
        while (iterator.hasNext()){
            System.out.println("\t|-"+iterator.next());
        }
    }
}
