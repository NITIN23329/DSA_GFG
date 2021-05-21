package dp.unboundedKnapsack;

import java.util.Arrays;
//problem link : https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1#
public class UnboundedKnapsack {
    // time complexity O(2^W) => loose bound
    /* for every item : we have 2 options either include it (only if space is left in knapsack) or we can always exclude item.
        --> if item's can be included in a knapsack , include it and consider current item again in next recursive call,
        --> if item is not  included , recursively call for next item.

     */
    static int recursive(int N, int W, int[] val, int[] wt) {
        return recursiveHelpr(0,W,0,wt,val);
    }
    private static int recursiveHelpr(int i,int cap,int curr,int[] wt,int[] val){
        if(i==wt.length)return 0;
        if(curr+wt[i]<=cap)
            return Math.max(val[i]+recursiveHelpr(i,cap,curr+wt[i],wt,val),
                    recursiveHelpr(i+1,cap,curr,wt,val));
        return  recursiveHelpr(i+1,cap,curr,wt,val);
    }

    // time complexity O(N*W)
    // memoization of above recursive approach
    static int memoization(int N, int W, int[] val, int[] wt) {
        int[][] dp = new int[N][W+1];
        for(int i=0;i<N;i++) Arrays.fill(dp[i],-1);
        return memoHelpr(0,W,0,wt,val,dp);
    }
    private static int memoHelpr(int i, int cap, int curr, int[] wt, int[] val, int[][] dp){
        if(i==wt.length)return 0;
        if(dp[i][curr]!=-1)return dp[i][curr];
        if(curr+wt[i]<=cap)
            return dp[i][curr] = Math.max(val[i]+ memoHelpr(i,cap,curr+wt[i],wt,val,dp),
                    memoHelpr(i+1,cap,curr,wt,val,dp));
        return  dp[i][curr] = memoHelpr(i+1,cap,curr,wt,val,dp);
    }

}
