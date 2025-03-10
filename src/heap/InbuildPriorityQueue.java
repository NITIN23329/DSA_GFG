package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class InbuildPriorityQueue {
    public static void main(String[] args) {
        // by default the inbuilt priority queue is a min heap;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(50);
        minHeap.add(20);
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(20);
        System.out.println(minHeap);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.peek());
        System.out.println(minHeap);
         //if we pass Collections.reverseOrder() in its constructor , it will be a max heap then
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(50);
        maxHeap.add(20);
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);
        System.out.println(maxHeap);
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap.peek());
        System.out.println(maxHeap);

        

    }
}
