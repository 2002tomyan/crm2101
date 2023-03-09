package sort;

public class heapSort {

    private int[] heap;
    private int limit;
    private int heapSize;

    public heapSort(int limit){
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

    public static void heapInsert(int[] arr,int index){
        while (arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public int pop(){
        int ans = heap[0];
        swap(heap,0,--heapSize);
        //重新调整成大根堆
        heapify(heap,0,heapSize);
        return ans;
    }

    public static void heapify(int[] arr,int index,int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left+1] > arr[left] ? left + 1:left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
