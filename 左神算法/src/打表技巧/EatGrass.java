package 打表技巧;

public class EatGrass {

    public static String winner1(int n){ //先手
        /*
        * 0  1  2  3  4  5
        * 后 先 后  先 先  先
        * */

        if(n < 5){
            return (n==0 || n==2) ? "后手" : "先手";
        }
        // n >= 5
        int base = 1; //先手决定吃的草数
        while (base < n){
            //一共base份草，先手先吃base份，（n-base）份草，后手吃
            if(winner1(n-base).equals("后手")){
                return "先手";
            }
            /*
                防止base * 4之后溢出
             */
            if(base > n/4){
                break;
            }
            base *= 4;
        }
        return "后手";
    }

    public static String winner2(int n){
        if(n % 5 == 0 || n % 5 == 2 ){
            return "后手";
        }else {
            return "先手";
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(winner1(i));
        }
        System.out.println("===============================");

        for (int i = 0; i < 50; i++) {
            System.out.println(winner2(i));
        }
    }
}
