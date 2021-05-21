package dp.longestCommonSubsequence;
// problem link : https://practice.geeksforgeeks.org/problems/edit-distance3702/1#
import java.util.Arrays;
/*
    approach : similar to LCS problem
    --> if s1[n] == s2[m] no need to do anything and goto n-1 , m-1
    --> if s1[n] !=s2[m] , 3 cases arises
        --> either we can remove s1[n]
        --> either we can remove s2[m]
        --> or we can replace s1[n] with s2[m]
    --> each of 3 cases take 1 operations, return min of them
    --> base case is then either string is empty , we need to return length of other string
 */

public class EditDistance {
    // time complexity : O(3^(nm))
    public int recursive(String s, String t)
    {
        return recursiveHelper(s,t,s.length(),t.length());
    }
    private int recursiveHelper(String s, String t, int n, int m){
        if(n==0)return m;
        if(m==0)return n;
        if(s.charAt(n-1)==t.charAt(m-1))
            return recursiveHelper(s,t,n-1,m-1);
        else
            return Math.min(Math.min( 1 + recursiveHelper(s,t,n,m-1) ,1+
                    recursiveHelper(s,t,n-1,m)), 1 + recursiveHelper(s,t,n-1,m-1));
    }
    // time and space complexity O(n*m)
    public int memoization(String s, String t)
    {   int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        return memoHelper(s,t,s.length(),t.length(),dp);
    }
    private int memoHelper(String s,String t,int n,int m,int[][] dp){
        if(n==0)return m;
        if(m==0)return n;
        if(dp[n][m]!=-1)return dp[n][m];
        if(s.charAt(n-1)==t.charAt(m-1))
            return memoHelper(s,t,n-1,m-1,dp);
        else
            return dp[n][m] =  Math.min(Math.min(1 + memoHelper(s,t,n,m-1,dp) ,1+
                    memoHelper(s,t,n-1,m,dp)), 1 + memoHelper(s,t,n-1,m-1,dp));
    }
}
