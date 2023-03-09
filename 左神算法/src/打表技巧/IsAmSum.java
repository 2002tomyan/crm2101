package 打表技巧;

public class IsAmSum {


    public static boolean isAmSum1(int n){
        for (int i = 1; i <= n; i++) {
            int sum = i;
            for (int j = i+1; j <= n; j++) {

                if(sum + j > n){
                    break;
                }
                if(sum + j == n){
                    return true;
                }
                sum = sum + j;

            }
        }
        return false;
    }

    //num 是否是 2 的某次方
    public static boolean isASSum(int n){
        if(n < 3){
            return false;
        }else {
            //2 的某一次幂，直接返回false
            return (n & (n-1)) != 0;
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(i+","+isAmSum1(i));
        }
    }
}
