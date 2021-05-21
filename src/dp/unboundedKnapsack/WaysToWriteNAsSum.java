package dp.unboundedKnapsack;
//problem link : https://practice.geeksforgeeks.org/problems/ways-to-write-n-as-sum-1587115621/1#
public class WaysToWriteNAsSum {
    /*
        approach :
            --> we can take the given array as {1,2,3,4,5,6,7,....n}
            --> from this we will find # of ways to get sum as n
            --> for every value in array, either we can take it or don't take it and goto next element
            --> we can take a value only if it is < reqd sum
            --> note that we can use a particular value as much as we want
     */
    int countWays(int n){
        return recursiveHelper(n,1);
    }
    private int recursiveHelper(int sum,int val){
        if(sum==0)return 1;
        if(sum-val<0)return 0;
        return recursiveHelper(sum-val,val)+recursiveHelper(sum,val+1);
    }
    int memoization(int n){
        int[][] dp = new int[n+2][n+2];
        for(int i=0;i<=n+1;i++)
            for(int j=0;j<=n+1;j++)
                dp[i][j]= -1;
        return memoHelper(n,1,dp)-1;
    }
    private int memoHelper(int sum, int val, int[][] dp){
        if(sum==0)return 1;
        if(dp[sum][val]!=-1)return dp[sum][val];
        if(sum-val<0)return 0 ;
        return dp[sum][val] = (memoHelper(sum-val,val,dp)+ memoHelper(sum,val+1,dp))%((int)1e9+7);

    }
}
