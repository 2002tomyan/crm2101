package org.lxh.demo13.propertiesdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo01 {
    public static void main(String[] args) {
        /*
        设置和取得属性
        Properties pro = new Properties();
        pro.setProperty("BJ","Beijing");
        pro.setProperty("TJ","Tianjin");
        pro.setProperty("NJ","Nanjing");
        System.out.println(pro.getProperty("BJ"));
        System.out.println(pro.getProperty("SC"));
        System.out.println(pro.getProperty("SC","没有发现"));

         */

        /*
        写入文件
        Properties pro = new Properties();
        pro.setProperty("BJ","Beijing");
        pro.setProperty("TJ","Tianjin");
        pro.setProperty("NJ","Nanjing");
        //设置属性的文件保存路径
        File file = new File("D:" + File.separator + "area.properties");
        try {
            pro.store(new FileOutputStream(file),"Area info");
        } catch (Exception e) {
           e.printStackTrace();
        }

        */
/*
        //读取文件信息
        Properties properties = new Properties();
        File file = new File("D:" + File.separator + "area.properties");
        try {
            properties.load(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("BJ"));

        */
        /*
        Properties pro = new Properties();
        pro.setProperty("BJ","Beijing");
        pro.setProperty("TJ","Tianjin");
        pro.setProperty("NJ","Nanjing");
        //设置属性的文件保存路径
        File file = new File("D:" + File.separator + "area.xml");
        try {
            pro.storeToXML(new FileOutputStream(file),"Area info");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        Properties properties = new Properties();
        File file = new File("D:" + File.separator + "area.xml");
        try {
            properties.loadFromXML(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("BJ"));

    }
}
