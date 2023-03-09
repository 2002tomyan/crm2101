package 排序.sort3;

import static 排序.sort3.printAndSwap.print;
import static 排序.sort3.sort.*;

public class Test {

    public static void main(String[] args) {
        int[] arr = {1, 4,4,4,4,4,4 ,7 ,3, 5, 6, 8,4,4,4};
        selectSort(arr);
        print(arr);
        System.out.println("");
        bubbleSort(arr);
        print(arr);
        System.out.println("");
        Insertion(arr);
        print(arr);
    }
}
