package dp.longestIncreasingSubsequence;
//https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumNumberOfJumps {
    // time complexity O(n^2) ,got a TLE
    // space complexity O(n)
    // can be done with queue also
    static int dpSolution(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<=i+arr[i] && j<arr.length;j++){
                if(dp[i]==Integer.MAX_VALUE)break;
                dp[j] = Math.min(dp[j],1+dp[i]);
            }

        return dp[n-1]==Integer.MAX_VALUE? -1 : dp[n-1];
    }
    // time complexity O(n),  accepted
    // space complexity O(n)
    /*
        --> this is typically a bfs.
        --> we traversed from rightmost reachable index to leftmost reachable index cuz,
        --> if we go from left to right it will take O(n^2) as we not know upto which index we visited on right
        --> if we traverse from right to left , we can visit only non visited indexes
        --> as soon as we hit a visited index, we stop cuz all index left to it are already visited previously
        --> do a dry run

     */
    static int queueSolution(int[] arr){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        while(!q.isEmpty()){
            int[] x = q.poll();
            if(x[0]==arr.length-1)return x[1];
            for(int i=Math.min(arr.length-1,x[0]+arr[x[0]]);i>=x[0] && !visited[i];i--){
                visited[i] = true;
                q.add(new int[]{i,x[1]+1});
            }
        }
        return -1;
    }
}
