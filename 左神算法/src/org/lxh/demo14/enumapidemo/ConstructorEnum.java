package org.lxh.demo14.enumapidemo;

//通过构造方法给属性赋值
enum Color{
    RED("红色"),GREEN("绿色"),BLUE("蓝色");
    private Color(String name){
        this.setName(name);
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class ConstructorEnum {
    public static void main(String[] args) {
        for (Color c : Color.values()) {
            System.out.println(c.ordinal()
            +"-->"+c.name()
            +"("+c.getName()+")");
        }
    }
}
