package dp.unboundedKnapsack;
// problem link : https://practice.geeksforgeeks.org/problems/rod-cutting/0#
import java.util.Arrays;

public class RodCutting {
    // recursive time complexity O(2^n)
    /*
        approach : unbounded knapsack having Capacity = n
            --> for a particular length, either we can add it to our current rod length may be multiple times or we don't
            --> we can only add a particular length if current rod length + particular length <= required length.
            --> find result if we add particular length or if we don't
            --> return max of above step.
     */
    private static int recursive(int [] arr,int n){
        return recursiveHelper(0,1,n,arr);
    }
    private static int recursiveHelper(int curr,int len,int n,int[] arr){
        if(len==n+1)return 0;
        if(curr+len<=n)
            return Math.max(arr[len-1]+recursiveHelper(curr+len,len,n,arr),recursiveHelper(curr,len+1,n,arr));
        return recursiveHelper(curr,len+1,n,arr);
    }
    // memoization of above step , time complexity : O(n*n) as sum = n
    private static int memoization(int [] arr,int n){
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
        return memoHelper(0,1,n,arr,dp);
    }
    private static int memoHelper(int curr, int len, int n, int[] arr, int[][] dp){
        if(len==n+1)return 0;
        if(dp[len][curr]!=-1)return dp[len][curr];
        if(curr+len<=n)
            return dp[len][curr] = Math.max(arr[len-1]+ memoHelper(curr+len,len,n,arr,dp), memoHelper(curr,len+1,n,arr,dp));
        return dp[len][curr] = memoHelper(curr,len+1,n,arr,dp);
    }
    // time complexity O(n*n)
    private static int bottomUp(int [] arr,int n){
        int[][] dp = new int[n+1][n+1];
        for(int len =1;len<=n;len++)
            for(int curr=1;curr<=n;curr++){
                if(curr-len>=0)
                    dp[len][curr] = Math.max(arr[len-1]+dp[len][curr-len],dp[len-1][curr]);
                else  dp[len][curr] = dp[len-1][curr];
            }
        return dp[n][n];
    }

}
