package sort;

import static sort.Sort.*;

public class test {
    public static void main(String[] args) {
        int[] arr = {4,7,8,1,3,6,9};
//        selectSort(arr);
//        print(arr);
//        bubbleSort(arr);
//        print(arr);
        insertSort(arr);
        print(arr);
    }
}
