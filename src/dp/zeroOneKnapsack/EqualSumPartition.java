package dp.zeroOneKnapsack;

import java.util.Arrays;

public class EqualSumPartition {
    // time complexity O(n*sum/2)
    // let the sum of both sets  = x
    // so x+x must be total sum of given array
    // or sum must be 2*x i.e. even
    // after we find that sum is even , we can check for a subset with sum=x, all remaining elements can goto other set
    // memoization solution
    public boolean memoSolution(int[] a, int n) {
        int sum = 0;
        for(int ele : a)sum+=ele;
        if(sum%2==1)return false;
        sum/=2;
        int[][] dp = new int[n][sum+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return findSubsetSum(0, a, 0, sum, dp) == 1;
    }
    private int findSubsetSum(int i,int[] a,int curr,int sum,int[][] dp){
        if(i==a.length)
            return curr == sum ? 1 : 0;
        if(dp[i][curr]!=-1)return dp[i][curr];
        if(curr+a[i]<=sum){
            int x = findSubsetSum(i+1,a,curr+a[i],sum,dp);
            int y = findSubsetSum(i+1,a,curr,sum,dp);
            return dp[i][curr] = x==1 || y==1? 1 :0 ;
        }
        return dp[i][curr] = findSubsetSum(i+1,a,curr,sum,dp);
    }
    // time complexity O(n*sum/2)
    // base case is if sum==0, no matter what the value of n is , answer is always True.
    public boolean bottomUP(int[] a, int N) {
        int Sum = 0;
        for(int ele : a)Sum+=ele;
        if(Sum%2==1)return false;
        Sum/=2;
        boolean[][] dp = new boolean[N+1][Sum+1];
        for(int i=0;i<N+1;i++)dp[i][0] = true;
        for(int n=1; n<=N;n++)
            for(int sum=1;sum<=Sum;sum++){
                if(a[n-1]<=sum)
                    dp[n][sum] = dp[n-1][sum-a[n-1]] || dp[n-1][sum];
                else dp[n][sum] = dp[n-1][sum];
            }
        return dp[N][Sum];
    }
}
