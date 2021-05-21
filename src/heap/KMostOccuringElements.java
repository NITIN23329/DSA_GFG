package heap;
// problem link : https://practice.geeksforgeeks.org/problems/most-occurring-elements-1587115620/1/?track=SPC-Heap&batchId=154
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostOccuringElements {
    void kMostOccuring(int arr[], int n, int k){
        Map<Integer , Integer> map = new HashMap<>(n);
        for(int ele : arr){
            if(map.containsKey(ele))map.put(ele ,map.get(ele)+1);
            else map.put(ele , 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        int i=0;
        for(int ele : map.values()){
            if(i++<k){
                pq.add(ele);
            }
            else{
                if(pq.peek()<ele){
                    pq.poll();
                    pq.add(ele);
                }
            }
        }
        long sum = 0L;
        while(!pq.isEmpty())sum+=pq.poll();
        System.out.println(sum);
    }
}
