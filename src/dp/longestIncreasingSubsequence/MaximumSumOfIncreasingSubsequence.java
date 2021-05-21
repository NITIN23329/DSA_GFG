package dp.longestIncreasingSubsequence;

import java.util.Arrays;
// problem link : https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1#
public class MaximumSumOfIncreasingSubsequence {
    // time complexity O(2^n)
    /*
        approach : this problem is similar to LIS
        --> we can either add a element to our current sum or not
        -->we can only add current element if the previously added element is < than current element
        --> we can always skip the current element
     */
    public int recursive(int[] arr, int n){
        return recursiveHelper(-1,0,arr);
    }
    private int recursiveHelper(int previ, int curri, int[] arr){
        if(curri==arr.length)
            return 0;
        if(previ==-1 || arr[previ]<arr[curri])
            return Math.max(arr[curri] + recursiveHelper(curri,curri+1,arr),
                    recursiveHelper(previ,curri+1,arr));
        return recursiveHelper(previ,curri+1,arr);
    }
    // time and space complexity O(n^2)
    // memoization of above solution
    public int memoization(int[] arr, int n){
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return memoHelper(-1,0,arr,dp);
    }
    private int memoHelper(int previ, int curri, int[] arr,int[][] dp){
        if(curri==arr.length)
            return 0;
        if(dp[previ+1][curri]!=-1)return dp[previ+1][curri];
        if(previ==-1 || arr[previ]<arr[curri])
            return dp[previ+1][curri] = Math.max(arr[curri] +memoHelper(curri,curri+1,arr,dp),
                    memoHelper(previ,curri+1,arr,dp));
        return dp[previ+1][curri] = memoHelper(previ,curri+1,arr,dp);
    }
    // time  complexity O(n^2) , space complexity O(n)
    // this approach is inspired from bottomUp solution of LIS.
    public int bottomUp(int[] arr, int n){
        int[] dp = new int[n];
        int max = arr[0];
        for(int i=0;i<n;i++){
            dp[i] = arr[i];
            for(int j=0;j<i;j++)
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+arr[i]);
                    max = Math.max(dp[i],max);
                }
        }
        return max;
    }
}
