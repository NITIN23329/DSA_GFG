package dp.fibonacci;
// problem link : https://practice.geeksforgeeks.org/problems/count-number-of-hops-1587115620/1/?track=DSASP-DP&batchId=154
import java.util.Arrays;

public class CountNumberOfHops {
    // time complexity : O(3^n)
    static long recursive(int n){
        return recursiveHelper(n);
    }
    static long recursiveHelper(int n){
        if(n==0)return 1L;
        if(n<0)return 0L;
        return (recursiveHelper(n-1) + recursiveHelper(n-2) + recursiveHelper(n-3))%((int)1e9+7);
    }
    // memoization of recursive solution time and space complexity O(n)
    static long memoization(int n){
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return memoHelper(n,dp);
    }
    static long memoHelper(int n, long[] dp){
        if(n==0)return 1L;
        if(n<0)return 0L;
        if(dp[n]!=-1)return dp[n];
        return dp[n] = (memoHelper(n-1,dp) + memoHelper(n-2,dp) + memoHelper(n-3,dp))%((int)1e9+7);
    }
    // bottom up dp with time and space complexity O(n)
    static long bottomUp(int n){
        long[] dp = new long[n+3];
        dp[0] = 1L;
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;
        for(int i=4;i<=n;i++)
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%((int)1e9+7);
        return dp[n];
    }
    // bottom up dp with time  O(n) and space complexity O(1)
    static long countWays(int n){
        long n_1 = 4L;
        long n_2= 2L;
        long n_3 = 1L;
        long curr = 0;
        for(int i=4;i<=n;i++){
            curr = (n_1 + n_2 + n_3)%((int)1e9+7);
            n_3 = n_2;
            n_2 = n_1;
            n_1 = curr;
        }
        if(n==1)curr= n_3;
        else if(n==2)curr = n_2;
        else if(n==3)curr = n_1;
        return curr;
    }
}
