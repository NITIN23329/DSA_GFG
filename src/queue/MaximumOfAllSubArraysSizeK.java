package queue;
/*********************************IMPORTANT********************************************
 * problem link : https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1/?track=SPC-Queue&batchId=154
 * soltuion link : https://practice.geeksforgeeks.org/tracks/SPC-Queue/?batchId=154
 *
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubArraysSizeK {
        static ArrayList <Integer> maxOfAllSubArraysNaive(int [] arr, int n, int k)
        {
            // time complexity O(nk)
            // space complexity O(1);
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<n-k+1;i++){
                int max = arr[i];
                for(int j=i;  j<i+k;j++)
                    max = Math.max(max,arr[j]);
                list.add(max);
            }
            return list;
        }
    static ArrayList <Integer> maxOfAllSubArraysEfficient(int[] arr, int n, int k)
    {   //time complexity is O(2n)
        // space complexity O(k)
        /**
            approach:
            maintain a dequeue of size k which stores indexes;
            first elements always give max of current window.
            when ever the max element goes out of current window . remove it from dq
            if the current element is greater then max; remove first element and add it to first of dq
            also remove smaller elements than current elements from last of dq
         */
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(0);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i = 1; i < n ; i++){
            int ele = arr[i];
            if(!dq.isEmpty() && dq.peekFirst()+k-1<i)
                dq.pollFirst();
            if(!dq.isEmpty() && ele>=arr[dq.peekFirst()]){
                dq.pollFirst();
                dq.addFirst(i);
            }
            while (!dq.isEmpty() && arr[dq.peekLast()]<=ele)
                dq.pollLast();
            dq.addLast(i);
            list.add(arr[dq.peekFirst()]);
        }
        for(int i=0;i<k-1;i++)
            list.remove(0);

        return list;

    }
}
