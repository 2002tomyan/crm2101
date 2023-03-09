package 排序.sort1;

public class printAndSwap {

    //交换
    public static void swap(int[] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap2(int[] arr,int i,int j)
    {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    //打印方法
    public static void print(int[] arr)
    {
        if(arr == null || arr.length<2)
        {
            return;
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
