package greedy;
/**
 * *************************************************IMPORTANT*******************************************
problem link : https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1/?track=DSASP-Greedy&batchId=154
*/
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;


public class JobScheduling {
    // time complexity : O(MAX (n,maxDeadline) * logn)
    // space compelxity : O(n)
    /*
        ---> approach : greedy
        --> suppose we are at time t, what jobs can we do on time t?, all jobs having deadline>=t.
        --> So we start from time t = maxDealine, we add all jobs having deadline>= t to a maxheap according to profit,
        --> Then for time t, we take maximum profit job from maxHeap. then we reduce time t by 1
        --> again we add all jobs having deadline time t-1 and take out maximum profit job and so on.
        --> We do this until t == 0 or we traversed through all job.
        --> if we are out of jobs but time>0, we simply take out maximum profit job and reduce our time by 1
     */
    public int[] jobScheduling(Job[] arr, int n){
        int[] ans = new int[2];
        Arrays.sort(arr,(a,b)->(a.deadline==b.deadline?b.profit-a.profit:b.deadline - a.deadline));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int time = arr[0].deadline;     // maximum deadline
        int i = 0;
        while(i<n || time>0){
            while(i<n && arr[i].deadline>=time){
                pq.add(arr[i].profit);
                i++;
            }
            if(!pq.isEmpty()){
                ans[0]++;
                ans[1]+=pq.poll();
            }
            time--;
            if(pq.isEmpty() && i==n)break;
        }
        return ans;
    }
}
/*
17
1 56 288 2 27 435 3 67 401 4 64 368 5 94 248 6 54 361 7 43 108 8 96 167 9 73 251 10 96 170 11 14 156 12 78 184 13 61 370 14 77 424 15 68 397 16 40 375 17 36 218
final ans : 17 4921

 */
class Job {
    int id, profit, deadline;
     Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}