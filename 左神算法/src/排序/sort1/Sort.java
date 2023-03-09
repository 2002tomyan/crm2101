package 排序.sort1;
import java.util.Arrays;
import java.util.Map;

import static 排序.sort1.printAndSwap.swap;

public class Sort {

    //选择排序（n^2)
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    //冒泡排序（n^2) 改进了的冒泡算法
    public static void bubbleSort(int[] arr)
    {
        if(arr == null || arr.length<2)
        {
            return;
        }

        for(int i = arr.length-1;i>0;i--) {
            //0~N-1
            //0~N-2
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    //0~0
    //0~1
    //0~2
    //0~3 ......  0~n

    //插入排序（n^2)
    public static void insertionSort(int[] arr)
    {
        if(arr==null || arr.length<2)
        {
            return;
        }
        for(int i = 1;i<arr.length;i++)
        {
            for(int j = i-1;j>=0;j--)
            {
                if(arr[j+1]<arr[j])
                {
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public void bubble1(int[] arr){
        for (int i=1;i<arr.length;i++){
            for (int j = 0;j<arr.length;j++){
                if(arr[i]<arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }

    //归并排序

    //采用递归的方式实现
    public static void mergeSort1(int[] arr){
        if(arr == null || arr.length<2)
        {
            return;
        }
        process(arr,0,arr.length-1);
    }

    public static void process(int[] arr,int left,int right){

        if(left == right){
            return;
        }
        int mid = left + (right-left)/2;
        //左部分有序
        process(arr,left,mid);
        //右部分有序
        process(arr,mid+1,right);
        //整体有序
        merge(arr,left,mid,right);
    }
    public static void merge(int[] arr,int left,int mid,int right){

        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;

        //两个指针相互比较
        while (p1 <= mid && p2 <= right){

            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //比较完毕后，左部分剩余的数
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }

        //右部分剩余的数
        while (p2 <= right){
            help[i++] = arr[p2++];
        }

        for(i = 0;i<help.length;i++){
            arr[left + i] = help[i];
        }
    }

    public static void mergeSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        int N = arr.length;
        int mergeSize = 1;//左组的大小

        while (mergeSize < N){
            int left = 0;

            while (left < N){
                int mid = left + mergeSize -1;
                if(mid > N){
                    break;
                }
                int right = Math.min(mid + mergeSize,N-1);
                merge(arr,left,mid,right);
                left = right + 1;
            }
            //防止溢出
            if(mergeSize > N/2){
                break;
            }
            mergeSize = mergeSize << 1;
        }
    }

    //快速排序
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr,int left,int right){
        if(left > right){
            return -1;
        }
        if(left == right){
            return left;
        }
        int lessEqual = left-1;
        int index = left;
        while (index < right){
            if(arr[index] <= arr[right]){
                swap(arr,index,++lessEqual);
            }
            index++;
        }
        swap(arr,++lessEqual,right);
        return lessEqual;
    }

    public static void quickSort1(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process1(arr,0,arr.length-1);
    }

    public static void process1(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        int M = partition(arr,left,right);
        process1(arr,left,M-1);
        process1(arr,M+1,right);
    }

    public static int[] netherlandsFlags(int[] arr,int left,int right){
        if(left > right){
            return new int[] {-1,-1};
        }
        if(left == right){
            return new int[] {left,right};
        }

        int less = left - 1; // <区右边界
        int more = right; // > 区左边界
        int index = left;  // 下标

        while (index < more){
            //当[i] == num 的时候，i++
            if(arr[index] == arr[right]){
                index++ ;
            }else if(arr[index] < arr[right]){
                swap(arr,index++,++less);
            }else {
                swap(arr,index,--more);
            }
        }
        swap(arr,more,right);

        return new int[] {less+1,more};
    }

    public static void quickSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process2(arr,0,arr.length-1);
    }

    public static void process2(int[] arr,int left,int right){
        if(left >= right){
            return;
        }

        int[] equalArea = netherlandsFlags(arr,left,right);
        process2(arr,left,equalArea[0]-1);
        process2(arr,equalArea[1]+1,right);
    }

    public static void quickSort3(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process3(arr,0,arr.length-1);
    }

    public static void process3(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        swap(arr,left + (int)(Math.random() * (right - left + 1)),right);
        int[] equalArea = netherlandsFlags(arr,left,right);
        process3(arr,left,equalArea[0]-1);
        process3(arr,equalArea[1]+1,right);
    }

    //计数排序
    public static void countSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }

        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }

        int[] bucket = new int[max + 1];
        for (int i = 0; i <arr.length; i++) {
            //0位置下放关于0的数，0的位置上有多个数
            //1位置上，放值为1的数
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j<bucket.length;j++) {
            while (bucket[j]-- > 0) {
                //0的位置上有几个0的数，打印几个
                arr[i] = j;
                i++;
            }
        }
    }


    //基数排序
    //通常来讲，在非负数，每个数都是十进制的情况下
    public static void radixSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        radixSort(arr,0,arr.length-1,maxbatis(arr));
    }

    public static int maxbatis(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while (max != 0){
            res++;
            max /= 10;
        }
        return res;
    }

    public static int getDigit(int x,int d){
        return ((x/(int)Math.pow(10,d-1)) % 10);
    }

    public static void radixSort(int[] arr,int left,int right,int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] help = new int[right - left + 1];

        /**
         * 确定每个位置上的数在count位置上的个数
         */

        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (i = left; i <= right; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            /**
             * 求前缀和
             */
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            /**
             * 将数字按照各位数字得大小装桶
             */
            for (i = right; i >= left; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }

            /**
             * 将按照位数排好的数字倒出
             */
            for (i=left,j=0;i<=right;i++,j++){
                arr[i] = help[j];
            }
        }
    }
}

