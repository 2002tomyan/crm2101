package 二分法.Binary;

import static 二分法.Binary.BinaryFind.*;

public class Test {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,2,2,2,2,2,2,3,7,8,9,9,9,9,9,9,10};
        int n = 9;
//        Boolean b =  binaryFind(arr,n);
//        System.out.println(b);
        int a = nearestIndex2(arr,n);
        System.out.println(a);
    }
}
