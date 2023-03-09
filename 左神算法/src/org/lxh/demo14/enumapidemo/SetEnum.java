package org.lxh.demo14.enumapidemo;

enum Color1{
    RED,GREEN,BLUE;
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        switch (this){
            case RED :{
                if("红色".equals(name)){
                    this.name = name;
                }
                else {
                    System.out.println("设置内容错误。");
                }
                break;
            }
            case GREEN:{
                if("绿色".equals(name)){
                    this.name = name;
                }else {
                    System.out.println("设置内容错误。");
                }
                break;
            }
            case BLUE:{
                if("蓝色".equals(name)){
                    this.name = name;
                }
                else {
                    System.out.println("设置内容错误。");
                }
                break;
            }
        }
    }
}
public class SetEnum {
    public static void main(String[] args) {
        Color1 c = Color1.BLUE;
        c.setName("兰色");
        c.setName("蓝色");
        System.out.println(c.getName());
    }
}
