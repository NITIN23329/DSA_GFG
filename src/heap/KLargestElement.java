package heap;
// problem link : https://practice.geeksforgeeks.org/problems/k-largest-elements3736/1/?track=SPC-Heap&batchId=154
// another problem : https://practice.geeksforgeeks.org/problems/kth-largest-element5034/1/?track=SPC-Heap&batchId=154
// yet another problem : https://practice.geeksforgeeks.org/problems/kth-largest-element5034/1/?track=SPC-Heap&batchId=154
import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElement {
    // first make a min heap of first k elements , the top element represent smallest element
    // for k to n elements if the top elements is smaller than current element ,
    // we remove top element and add the current element
    public static ArrayList<Integer> kLargest(int[] arr, int n, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i = 0;i<k;i++)pq.add(arr[i]);
        for(int i = k;i<n;i++){
            if(pq.peek()>arr[i])continue;
            pq.poll();
            pq.add(arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>(k);
        for(int i = 0;i<k;i++)list.add(0);
        for(int i = k-1;i>=0;i--)
            list.set(i ,pq.poll());

        return list;
    }
}
