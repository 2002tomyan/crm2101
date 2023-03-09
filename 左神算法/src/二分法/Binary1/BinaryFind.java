package 二分法.Binary1;

public class BinaryFind {

    //查询数组上的一个数，是否在里面
    public static boolean findShu(int[] arr,int n){

        if(arr.length == 0 || arr == null)
        {
            return false;
        }

        int left = 0;
        int right = arr.length-1;
        while (left <= right){

            int mid = left + (right-left)/2;
            if(arr[mid] == n){
                return true;
            }
            else if(arr[mid] > n){
                right = mid-1;
            }
            else if(arr[mid] < n){
                left = mid + 1;
            }
        }
        return false;
    }

    //招数的下标
    public static int findShuIndex(int[] arr, int n){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == n){
                return mid;
            }
            else if(arr[mid] > n){
                right = mid-1;
            }
            else if(arr[mid] < n){
                left = mid + 1;
            }
        }
        return -1;
    }

    //在arr上，找 >= value  value最左位置的下标





    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9,10,11,13,14};
        int n = 5;
        boolean shu = findShu(arr, n);
        System.out.println(shu);

        int shuIndex = findShuIndex(arr, 10);
        System.out.println(shuIndex);
    }

}
