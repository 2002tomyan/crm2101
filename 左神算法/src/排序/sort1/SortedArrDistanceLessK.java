package 排序.sort1;

import java.util.PriorityQueue;

public class SortedArrDistanceLessK {

    public void arrDistance(int[] arr,int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (;index <= Math.min(arr.length-1,k); index++) {
            heap.add(arr[index]);
        }
        int i=0;
        for (;index < arr.length;i++,index++){
            //先删后加
            arr[i] = heap.poll();
            heap.add(arr[index]);
        }

        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }

    public static void main(String[] args) {

    }
}
