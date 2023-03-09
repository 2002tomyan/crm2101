package 排序.sort2;

import static 排序.sort1.Sort.insertionSort;
import static 排序.sort1.Sort.selectSort;
import static 排序.sort1.printAndSwap.print;
import static 排序.sort2.sort.*;

public class Test {

    public static void main(String[] args)
    {
        int[] arr= {1,5,6,4,8,8,9,2,1,4,5,6};
        selectSort1(arr);
        bubbleSort(arr);
        Insertion(arr);
        print(arr);

    }
}
