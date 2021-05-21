package heap;

import java.util.PriorityQueue;

/**
 * ****************************************IMPORTANT*************************************
 * problem link : https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1/?track=SPC-Heap&batchId=154
 */
public class MinimumCostOfRopes {
    // time complexity O(nlogn)
    // approach : we take 2 smallest ropes and merge them because their merging cost is minimum
    // after merging we push it to priority queue until there is 1 rope left
    void minCost(long arr[], int n) {
        PriorityQueue<Long> pq =new PriorityQueue<>(n);
        for(long ele : arr)pq.add(ele);
        long sum = 0L;
        while(pq.size()!=1){
            long m1 = pq.poll();
            long m2 = pq.poll();
            sum+=m1+m2;
            pq.add(m1+m2);
        }
        System.out.println(sum);
    }
}
