package org.lxh.demo14.colordemo;

class Color{
    public static final Color RED = new Color("红色");
    public static final Color GREEN = new Color("绿色");
    public static final Color BLUE = new Color("蓝色");
    private String name;
    private Color(String name){
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Color getInstance(int i){
        switch (i){
            case 1: {
                return RED;
            }
            case 2:{
                return GREEN;
            }
            case 3:{
                return BLUE;
            }
            default:{
                return null;
            }
        }
    }
}

public class ColorDemo01 {
    public static void main(String[] args) {
        Color red = Color.RED;
        System.out.println(red.getName());
        Color instance = Color.getInstance(3);
        System.out.println(instance.getName());
    }
}
