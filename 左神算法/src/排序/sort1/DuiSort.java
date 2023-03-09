package 排序.sort1;

public class DuiSort {

    private int[] heap; //堆
    private final int limit;
    private int heapSize;

    public DuiSort(int limit){
        heap = new int[limit];
        this.limit = limit;
        heapSize = 0;
    }

    public boolean isEmpty(){
        return heapSize == 0;
    }
    public boolean isFull(){
        return heapSize == limit;
    }
    public void push(int value){
        if(heapSize == limit){
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap,heapSize++);
    }

    //变成大根堆
    public static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }


    //删除根节点，但这个堆仍然保持大根堆得形式
    public int pop(){
        int ans = heap[0];
        swap(heap,0,--heapSize);
        heapify(heap,0,heapSize);
        return ans;
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 +1;
        while (left < heapSize){

            int largest = left+1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr,largest,index);
            //将之前largest的位置赋值给index，重新向下确定大根堆
            index = largest;
            left = index * 2 + 1;
            //            if(left+1 < heapSize){
//                int largest = arr[left] > arr[left+1] ? left : left+1;
//                //找到较大孩子的值，充分考虑到父节点与其孩子节点之间的关系
//                largest = arr[largest] > arr[index] ? largest : index;
//                if(largest == index){
//                    break;
//                }
//                swap(arr,largest,index);
//                //将之前largest的位置赋值给index，重新向下确定大根堆
//                index = largest;
//                left = index * 2 + 1;
//            }else{
//                int largest = left;
//                largest = arr[largest] > arr[index] ? largest : index;
//                if(largest == index){
//                    break;
//                }
//                swap(arr,largest,index);
//                //将之前largest的位置赋值给index，重新向下确定大根堆
//                index = largest;
//                left = index * 2 + 1;
//            }

        }

    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //调整成大跟堆
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr,i);
//        }


        //优化 只让整棵树变成大根堆
        for (int i = arr.length-1; i >=0 ; i--) {
            heapify(arr,i, arr.length);
        }

        int heapSize = arr.length;
        swap(arr,0,--heapSize);

        while (heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }


}
