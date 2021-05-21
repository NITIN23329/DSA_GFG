package dp.fibonacci;
// problem link : https://practice.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1#
import java.util.Arrays;

public class ReachAGivenScore {
    //recursive solution , time complexity O(3^N)
    /*
        approach :
            --> there are 3 choices , either subtract 3 form n or 5 or 10
            --> 8=  {3,5} and {5,3} , as they are considered as same so we need to remove duplicacy
            --> in order to remove duplicacy we will take numbers in sorted order i.e first we will subtract 3 then 5 then 10
            --> it will rule out possibilities like {5,3} or {10,5,3} or {10,3} so on

     */
    public long count(int n) {
        return recursiveHelper(n,3);
    }
    private long recursiveHelper(int n,int prev){
        if(n==0)return 1L;
        if(n<0)return 0L;
        long ans = 0L;
        if(prev<=10)
            ans+=recursiveHelper(n-10,10);
        if(prev<=5)
            ans+=recursiveHelper(n-5,5);
        if(prev<=3)
            ans+=recursiveHelper(n-3,3);
        return ans;
    }
    // time and space complexity O(11*n)
    public long memoization(int n) {
        long[][] dp = new long[n+1][11];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);
        return memoHelper(n,3,dp);
    }
    private long memoHelper(int n, int prev, long[][] dp){
        if(n==0)return 1L;
        if(n<0)return 0L;
        if(dp[n][prev]!=-1)return dp[n][prev];
        long ans = 0L;
        if(prev<=10)
            ans+= memoHelper(n-10,10,dp);
        if(prev<=5)
            ans+= memoHelper(n-5,5,dp);
        if(prev<=3)
            ans+= memoHelper(n-3,3,dp);
        return dp[n][prev] = ans;
    }
}
