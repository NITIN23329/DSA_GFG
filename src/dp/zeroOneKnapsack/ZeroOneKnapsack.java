package dp.zeroOneKnapsack;

import java.util.Arrays;
// problem link : https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
// solution memoization : https://www.youtube.com/watch?v=fJbIuhs24zQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=4
// solution bottom up : https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5

public class ZeroOneKnapsack {

    //recursise approach (2^n) time
    // we have 2 choices for every item , either take it if possible or don't take it
    private int kanpsackRecursive(int[] wt, int[] val,int cap){
        return recursiveHelpr(0,wt,val,cap);
    }
    private int recursiveHelpr(int i,int[] wt,int[] val,int cap){
        if(i==wt.length)return 0;
        if(cap>=wt[i])
            return Math.max(val[i]+recursiveHelpr(i+1,wt,val,cap-wt[i]),
                    recursiveHelpr(i+1,wt,val,cap));
        return recursiveHelpr(i+1,wt,val,cap);
    }
    // memoization(top down) of above recursive approach
    // time complexity O(n*cap)
    /* approach :
        -->state variable are : index(i) and capacity (cap) . Create a dp table of 2D
        --> fill initial values by -1 , representing result is not calculate for start arr[i][cap]
        --> after finding recursive answer for a particular state, store it in arr[i][cap]
    */

     private int knapSackMemo(int W, int[] wt, int [] val, int n) {
        int[][] dp = new int[n][W+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return memoHelpr(0,wt,val,W,dp);
    }
    private  int memoHelpr(int i,int[] wt,int[] val,int cap,int[][] dp){
        if(i==wt.length)return 0;
        if(dp[i][cap]!=-1)return dp[i][cap];
        if(cap>=wt[i])
            return dp[i][cap] =  Math.max(val[i]+memoHelpr(i+1,wt,val,cap-wt[i],dp),
                    memoHelpr(i+1,wt,val,cap,dp));
        return dp[i][cap]  = memoHelpr(i+1,wt,val,cap,dp);
    }
    // bottom up of recursive code
    // time complexity O(N*W)
    static int knapSackBottomUp(int W, int[] wt, int[] val, int N)
    {
        int[][] dp = new int[N+1][W+1];
        // initialization of dp array using base case
        // when W ==0 ans is 0
        for(int i=0;i<N+1;i++)
            dp[i][0] = 0;
        // when n==0 ans is 0
        for(int j=0;j<W+1;j++)
            dp[0][j] = 0;
        // converting recursive calls to iterative ,  n represents # of items taken and w represents total weight available
        for(int n=1;n<=N;n++)
            for(int w=1;w<=W;w++){
                if(wt[n-1]<=w)
                    dp[n][w] = Math.max(val[n-1]+dp[n-1][w-wt[n-1]],dp[n-1][w]);
                else dp[n][w] = dp[n-1][w];
            }
        // our final answer is at dp[N][W];
        return dp[N][W];
    }
}
