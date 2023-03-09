package 排序.sort1;

public class SmallSum {
    public static int smallSum(int[] arr){
        if(arr == null || arr.length<2)
        {
            return 0;
        }
        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr,int left,int right){

        if(left == right){
            return 0;
        }
        int mid = left + (right-left)/2;
        return process(arr,left,mid) + process(arr,mid+1,right) + merge(arr,left,mid,right);
    }
    public static int merge(int[] arr,int left,int mid,int right){

        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;

        //两个指针相互比较
        while (p1 <= mid && p2 <= right){

            res  = res + arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
//            降序数
            //左边的数大于右边的数，先拷贝右边的数，等于的时候，拷贝左边的数
//            res  = res + arr[p1] > arr[p2] ? (mid - p1 + 1) : 0;
            //左边的数小于右边的数 先拷贝左边的，等于的时候，先拷贝右边的
            //help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        return res;
    }
}
