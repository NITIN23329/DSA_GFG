package dp.matrixChainMultiplication;

import java.util.Arrays;

/**
 * ***************************************IMPORTANT*****************************************
 * do on your own with time complexity O(n*k*k)
 * problem link : https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1#
 */
    /*
        approach :
        --> base cases are  :
            --> if eggs available == 1 , worst case would be to check each floor.
            --> if floor == 0 (l>r) , we dont have any floor to check.
        --> we first try to drop an egg from k = [l+1 to r-1]
        --> when we drop a egg from a floor , there are 2 cases , either it will break or it will not break
        --> if eggs gets break, we will recursively find # of attempts for floor[l,k-1]
        --> if egg don't break, we will recursively find # of attempts for floor[k+1,r]
        --> we take maximum of both cases as we are asked for worst case and we will add 1 to it cuz we dropped an egg from floor no k
        --> after finding answer for every k , we take minimum of all answers to get min # of attempts for floor[l to r]

     */
public class EggDropping {

    // time and space complexity : O(nk^3)
    static int memoization(int n, int k){
        int[][][] dp = new int[n+1][k+1][k+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=k;j++)
                Arrays.fill(dp[i][j],-1);
        return memoHelper(n,1,k,dp);
    }
    static int memoHelper(int eggs, int l, int r, int[][][] dp){
        if(eggs==1) return r-l+1;
        if(l>r)return 0;
        if(dp[eggs][l][r]!=-1)return dp[eggs][l][r];
        int ans = Integer.MAX_VALUE;
        for(int k = l;k<=r;k++){
            int eggBreaked = memoHelper(eggs-1,l,k-1,dp);
            int eggNotBreaked = memoHelper(eggs,k+1,r,dp);
            ans = Math.min(ans,1+Math.max(eggBreaked,eggNotBreaked));
        }
        return dp[eggs][l][r] =  ans;
    }
    // time complexity : O(nk^2)
    /*
           -->we can see from above solution that l and r do not matter
           --> for example # of attempts for floor [l=10,r=20] = # of attempts for floor[l=20,r=30]
           --> what matters if floor size
           --> On other thing is as our answer is always >=1, we dont need any initialization of dp.
     */
    static int eggDrop(int n, int f)
    {   int[][] dp =  new int[n+1][f+1];
        for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
        return helper(n,f,dp);

    }
    static int helper(int eggs,int floors,int[][] dp){
        if(eggs==1)return floors;
        if(floors==0)return 0;
        if(dp[eggs][floors]!=-1)return dp[eggs][floors];
        int ans = Integer.MAX_VALUE;
        for(int k=1;k<=floors;k++){
            int curr = 1 + Math.max(helper(eggs-1,k-1,dp),helper(eggs,floors-k,dp));
            ans = Math.min(ans,curr);
        }
        return dp[eggs][floors] = ans;
    }
}
