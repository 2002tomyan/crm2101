package sort;

import static sort.heapSort.heapInsert;
import static sort.heapSort.heapify;

public class Sort {

    /**
     * 两个数进行交换
     * @param arr 数组
     * @param i 数
     * @param j 数
     */
    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组中的内容
     * @param arr 数组
     */
    public static void print(int[] arr){
        for (int i = 0; i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    /**
     * 选择排序
     * @param arr 数组
     */
    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0 ;i < arr.length;i++){
            int minIndex = i;
            //找到最小的值，与其第一个数比较大小，若小于第一个数，则交换
            for (int j = i+1;j< arr.length;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
        }
    }

    /**
     * 冒泡排序
     * @param arr 数组
     */
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = arr.length-1;i>=0;i--){
            for (int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    /**
     * 冒泡排序1.0版
     * @param arr
     */
    public static void bubbleSort1(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0;i< arr.length;i++){
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arr 数组
     */
    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 1;i< arr.length;i++){
            for (int j = i-1;j>=0;j--){
                if(arr[j] > arr [j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    /**
     * 归并排序 用递归实现
     * @param arr
     */

    public static void mergeSort1(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr,0,arr.length-1);

    }

    public static void process(int[] arr,int left,int right){
        if(left == right) {
            return;
        }

        int mid = left + ((right-left)>>1);
        process(arr,left,mid);
        process(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr,int left,int mid, int right){
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid+1;

        while (p1 <= mid && p2 <= right){
//            if(p1 <= p2){
//                help[i++] = arr[p1++];
//            }
//            else {
//                help[i++] = arr[p2++];
//            }
            help[i++] = p1 <= p2 ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= right){
            help[i++] = arr[p2++];
        }

        for (i=0;i< help.length;i++){
            arr[left+i] = help[i];
        }
    }

    /**
     * 归并排序的非递归形式
     * @param arr
     */
    public static void mergeSort2(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        int N = arr.length;
        int mergeSize = 1;//左组的大小

        while (mergeSize < N){
            int left = 0;
            while (left < N){
                //找中点和右边界
                int mid = left + mergeSize - 1;
                if(mid > N){
                    break;
                }
                int right = Math.min(mid + mergeSize,N-1);
                merge(arr,left,mid,right);
                left = right + 1;
            }
            //防止溢出
            if (mergeSize > N/2){
                break;
            }
            mergeSize = mergeSize << 1;
        }
    }

    /**
     * 快排1.0版
     * @param arr
     */
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

    public static int partition(int[] arr,int left,int right){
        if(left > right){
            return -1;
        }
        if(left == right){
            return left;
        }

        int lessEquals = left - 1;
        int index = left;

        while (index < right){
            if(arr[index] <= arr[right]){
                swap(arr,index,++lessEquals);
            }
            index++;
        }
        swap(arr,++lessEquals,right);
        return lessEquals;
    }

    /**
     * 快排2.0
     * @param arr
     */
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

    public static int[] netherlandsFlags(int[] arr,int left,int right){
        if(left > right){
            return new int[] {-1,-1};
        }
        if(left == right){
            return new int[] {left,right};
        }

        int less = left - 1;
        int more = right;
        int index = left;

        while (index < more){
            if(arr[index] == arr[right]){
                index++;
            }else if(arr[index] < arr[right]){
                swap(arr,index++,++less);
            }else{
                swap(arr,index,--more);
            }
        }
        swap(arr,more,right);
        return new int[] {less+1,more};
    }

    /**
     * 快排3.0
     * @param arr
     */
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
        //生成一个随机的数，与最后一位进行交换
        //  swap(arr,left + (int)(Math.random() * (right - left + 1)),right);
        swap(arr,left+(int)(Math.random() * (right - left + 1)),right);
        int[] equalArea = netherlandsFlags(arr,left,right);
        process3(arr,left,equalArea[0]-1);
        process3(arr,equalArea[1]+1,right);
    }

    /**
     * 计数排序
     * @param arr
     */
    public static void countSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
//            if(max < arr[i]){
//                max = arr[i];
//            }
            max = Math.max(max,arr[i]);
        }
        int[] bucket = new int[max+1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j] --> 0){
                arr[i++] = j;
            }
        }
    }

    /**
     * 基数排序
     * @param arr
     */
    public static void radixSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        radixSort(arr,0,arr.length-1,maxbatis(arr));
    }

    public static int getDigit(int x,int d){
        return ((x / (int)Math.pow(10,d-1)) % 10);
    }

    public static void radixSort(int[] arr,int left,int right,int digit){
        int radix = 10;
        int i = 0,j = 0;
        int[] help = new int[radix - left + 1];



        for (int d = 1;d <= digit;d++){
            /**
             * 确定每个位置上的数在count位置上的个数
             */
            int[] count = new int[radix];
            for (i = left; i<=right;i++){
                j = getDigit(arr[i],d);
                count[j]++;
            }
            /**
             * 求前缀和
             */
            for (i = 1;i<radix;i++){
                count[i] = count[i] + count[i-1];
            }

            for (i = right;i>=left;i--){
                j = getDigit(arr[i],d);
                help[count[j]-1] = arr[i];
                count[j]--;
            }

            /**
             * 倒出所在的数据
             */
            for (i = left,j=0;i<=right;i++,j++){
                arr[i] = help[j];
            }
        }
    }
    public static int maxbatis(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while (max != 0){
            res++;
            max /= 10;
        }
        return res;
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for (int i = 0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);

        while (heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

}
