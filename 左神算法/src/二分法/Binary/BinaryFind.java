package 二分法.Binary;

public class BinaryFind {


    //查找有序数组上的一个数
    //arr[left] == n;
    public static boolean binaryFind(int[] arr,int n)
    {
        if(arr == null || arr.length == 0)
        {
            return false;
        }

        int left = 0;
        int right = arr.length-1;

        while (left <= right)
        {
            int mid = left + (right - left)/2;
            if(arr[mid] == n)
            {
                return true;
            }
            else if(arr[mid] > n)
            {
                right = mid -1;
            }
            else if(arr[mid] < n)
            {
                left = mid +1;
            }

        }
//        return arr[right] == n;
            return false;
    }

    //n*2+1 == ((n<<1) | 1)



    //在arr上，找 >= value 最左位置的下标
    public static int nearestIndex(int[] arr,int value)
    {
        int left = 0;
        int right = arr.length-1;
        int index = -1;

        while (left <= right)
        {
            int mid = left + ((right - left) >> 1);

            if(arr[mid] >= value)
            {
                index = mid;
                right = mid - 1;
            }

            else if(arr[mid] < value)
            {
                left = mid + 1;
            }
        }
        return index;
    }


    //在arr上，找 <= value 最右位置的下标
    public static int nearestIndex2(int[] arr,int num)
    {
        int left = 0;
        int right = arr.length-1;
        int index = -1;
        while (left <= right)
        {
            int mid = left + ((right - left) >> 1);
            if(arr[mid] > num)
            {
                right = mid - 1;
            }
            else if(arr[mid] <= num)
            {
                index = mid;
                left = mid + 1;
            }
        }
        return index;
    }

    //局部最小值问题
    //1.若只有 0 和 1 两个位置的下标，1位置的数比0位置的数大，则0位置为局部最小
    //2.若只有 N-1 和 N 两个位置的下标，N位置的数比N-1位置的数小，则N位置的数为局部最小
    //3.若有 i-1  i  i+1 这三个位置， i-1 > i , i+1 > i ，则i位置的数局部最小

    public static int getLessIndex(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        if(arr.length==1 || arr[0]<arr[1]){
            return 0;
        }
        if(arr[arr.length-1] < arr[arr.length-2]){
            return arr.length-1;
        }

        int left = 1;
        int right = arr.length-2;

        while (left < right){
            int mid = left + (right-left)/2;
            if(arr[mid]>arr[mid-1])
            {
                right = mid-1;
            }
            else if(arr[mid] > arr[mid+1]){
                left = mid+1;
            }
            else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,7,6,1,2,3,9};
        int lessIndex = getLessIndex(arr);
        System.out.println(lessIndex);
    }
}
