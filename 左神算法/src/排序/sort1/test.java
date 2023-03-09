package 排序.sort1;


import static 排序.sort1.DuiSort.heapSort;
import static 排序.sort1.SmallSum.smallSum;
import static 排序.sort1.Sort.*;
import static 排序.sort1.printAndSwap.print;

public class test {

    public static void main(String[] args)
    {
        int[] arr= {1,51,66,40,85,82,91,2,11,44,55,6};
//        int[] arr = {3,1,2,6,3};
//        selectSort(arr);
//        bubbleSort(arr);
//        insertionSort(arr);
//        mergeSort1(arr);
//        print(arr);
//        mergeSort1(arr);
//        mergeSort2(arr);
//        print(arr);
//        int count = smallSum(arr);
//        System.out.println(count);

//        int partition = partition(arr, 0, arr.length - 1);
//        System.out.println(partition);
//        quickSort2(arr);
//        DuiSort duiSort = new DuiSort(5);
//        duiSort.push(1);
//        duiSort.push(5);
//        duiSort.push(6);
//        duiSort.push(4);
//        duiSort.push(8);
//
////        System.out.println(duiSort.pop());
////
//        for (int i = 0; i < 5; i++) {
//            int pop = duiSort.pop();
//            System.out.print(pop+" ");
//        }

//        countSort(arr);
        heapSort(arr);
        print(arr);

    }
}
