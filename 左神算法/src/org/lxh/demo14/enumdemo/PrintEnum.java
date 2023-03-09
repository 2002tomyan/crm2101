package org.lxh.demo14.enumdemo;

public class PrintEnum {
    public static void main(String[] args) {
        for (Color c : Color.values()) {
            print(c);
        }
    }

    public static void print(Color color){
        switch (color){
            case RED :{
                System.out.println("红颜色");
                break;
            }
            case GREEN:{
                System.out.println("绿颜色");
                break;
            }
            case BLUE:{
                System.out.println("蓝颜色");
                break;
            }
            default:{
                System.out.println("未知颜色");
                break;
            }
        }
    }
}
