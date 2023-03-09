package digui;

public class ArrayMax {
    //求数组上的最大值，用递归实现
    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr,int left,int right){
        if(left == right){
            return arr[left];
        }
        int mid = left + ((right-left)>>1);//中点

        int leftMax = process(arr,0,mid);
        int rightMax = process(arr,mid+1,right);

        return Math.max(leftMax,rightMax);
    }
}
