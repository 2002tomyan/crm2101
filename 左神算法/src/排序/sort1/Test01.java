package 排序.sort1;

import java.util.PriorityQueue;

public class Test01 {
    public static void main(String[] args) {
        //小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(5);
        heap.add(7);
        heap.add(3);
        heap.add(0);
        heap.add(2);
        heap.add(5);

        while (!heap.isEmpty()){
            System.out.print(heap.poll()+ " ");
        }
    }
}
