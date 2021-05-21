package dp.longestCommonSubsequence;
// problem link : https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1/?track=DSASP-DP&batchId=154#
import java.util.Arrays;

public class LongestCommonSubsequence {
    // time complexity (2^(s1*s2))
    static int recursive(String s1, String s2){
        return recursiveHelper(s1,s2,0,0);
    }
    private static int recursiveHelper(String s1,String s2,int n,int m){
        // base case : if either string is empty length of lcs is 0
        if(n==0 || m==0)
            return 0;
        // if our s1[n-1] != s2[m-1] , then we can either goto previous in s1 or goto previous in s2
        // goto previous in s1 means check for s2[m-1] in previous characters of s1
        // goto previous in s2 means check for s1[n-1] in previous characters of s2
        // consider both and return max of them
        if(s2.charAt(n-1)!=s1.charAt(m-1))
            return Math.max(recursiveHelper(s1,s2,n,m-1),recursiveHelper(s1,s2,n-1,m));
        // we found s1[n-1] == s2[m-1] then return 1 + lcs in n-1 and m-1
        else
            return 1 + recursiveHelper(s1,s2,n-1,m-1);
    }
    // memoization of above recursive solution
    // time complexity O(s1*s2)
    public static int memoization(String s1, String s2){
        int n = s1.length(),m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return memoHelper(s1,s2,n,m,dp);
    }
    private static int memoHelper(String s1,String s2,int n,int m,int[][] dp){
        if(n==0 || m==0)
            return 0;
         if(dp[n][m]!=-1)return dp[n][m];
        if(s1.charAt(n-1)!=s2.charAt(m-1))
            return dp[n][m] = Math.max(memoHelper(s1,s2,n,m-1,dp),memoHelper(s1,s2,n-1,m,dp));
        else
            return dp[n][m] = 1 + memoHelper(s1,s2,n-1,m-1,dp);
    }
    // time complexity O(s1*s2)
    static int bottomUp(String s1, String s2){
        int N = s1.length(),M = s2.length();
        int[][] dp = new int[N+1][M+1];
        // initialization
        // no matter what N is, if M==0 ans is 0
        // no matter what M is , if N==0 ans is 0
        for(int n=1;n<=N;n++)
            for(int m = 1; m<=M;m++)
                if(s1.charAt(n-1)==s2.charAt(m-1))
                    dp[n][m] = 1 + dp[n-1][m-1];
                else dp[n][m] = Math.max(dp[n-1][m],dp[n][m-1]);

        return dp[N][M];
    }
}
