package Eor;

public class Eor {

    public static void eor(int[] arr){

        int eor = 0;
        for(int i = 0;i<arr.length;i++){
            eor = eor ^ arr[i];
        }
        System.out.println(eor);
    }

    //如何提取int数，最右侧的一个1
    //N & ( (~N) + 1)

    public static void zuiRight1(int n){
        int a = n & (~n+1);
        System.out.println(a);
    }

    //一个数组中，有两种数出现奇数次，其他数出现了偶数次，找到这两种数
    public static void findJiShu2(int[] arr){

        int eor = 0;
        for(int i = 0;i<arr.length;i++){
            eor = eor ^ arr[i];
        }
        //最终得到的eor = a ^ b
        //找到最右边一位为1得数
        int rightOne = eor & (~eor+1);
        int onlyOne = 0;//eor'
        for(int i = 0;i<arr.length;i++){
            //把arr数组中，因一位不同的数，全找出来，分成两个组
            //从而取出其中一个数
            // != rightOne  ==0
            if((rightOne & arr[i]) != 0){
                onlyOne = onlyOne ^ arr[i];
            }
        }
        //onlyOne ^ eor取出另为一个数
        System.out.println(onlyOne+","+(onlyOne ^ eor));
    }

    public static void findJiShu3(int[] arr){
        int eor = 0;
        for(int i = 0;i<arr.length;i++){
            eor = eor ^ arr[i];
        }

        int rightOne = eor ^ (~eor + 1);
        int onlyOne = 0;
        for(int i = 0;i<arr.length;i++){
            if((rightOne & arr[i]) != 0){
                onlyOne = onlyOne ^ arr[i];
            }
        }
        System.out.println(onlyOne+","+(onlyOne^eor));
    }

    //一个int 数中1的个数
    public static int bit1Counts(int n){

        int count = 0;
        while (n != 0){
            int rightOne = n & (~n+1);
            count++;
            n = n ^ rightOne;
        }
       return count;
    }

    public static void main(String[] args) {
//        int[] arr = {1,2,3,1,2,3,1,2,2,1,3};
//        eor(arr);
//        int n = 10;
//        zuiRight1(n);
        int[] arr = {1,1,1,2,2,2,2,4,4,4,4,5,5,5,5,6,6,7,7,7,7,7};
        findJiShu2(arr);
    }
}
