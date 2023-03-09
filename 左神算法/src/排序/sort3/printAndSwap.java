package 排序.sort3;

public class printAndSwap {

    public static void swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr){

        if(arr == null || arr.length<2)
        {
            return;
        }

        for(int i: arr)
        {
            System.out.print(i+" ");
        }
    }
}
