package 排序.sort3;

import static 排序.sort3.printAndSwap.swap;

public class sort {

    //选择排序
    public static void selectSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }

        for(int i=0;i < arr.length-1;i++ ){
            int minIndex = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex])
                {
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr){
        if(arr== null || arr.length<2){
            return;
        }
        for(int i = arr.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,i,j);
                }
            }
        }
    }

    //插入排序
    public static void Insertion(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        for(int i=1;i<arr.length;i++)
        {
            for(int j = i-1;j>=0;j--){
                if(arr[j]>arr[j+1]){
                    swap(arr,i,j);
                }
            }
        }
    }
}


