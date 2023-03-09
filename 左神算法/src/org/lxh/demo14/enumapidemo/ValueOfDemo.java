package org.lxh.demo14.enumapidemo;

public class ValueOfDemo {
    public static void main(String[] args) {
        Color1 c = Enum.valueOf(Color1.class, "BLUE");
        c.setName("兰色");
        c.setName("蓝色");
        System.out.println(c.getName());
    }
}
