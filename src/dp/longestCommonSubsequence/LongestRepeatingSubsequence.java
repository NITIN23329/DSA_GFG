package dp.longestCommonSubsequence;
// problem link : https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
import java.util.Arrays;

public class LongestRepeatingSubsequence {
    // time complexity O(2^n*n)
    /*
        approach :
            --> we need to find lcs in the given common string
            --> we will iterate 2 pointers : n amd m in the given string to find lcs
            --> if n==m , return max(f(n-1,m) and f(n,m-1)) as we can not choose single char in 2 different subsequence at same index
            --> if n!=m and s[n]==s[m],  return 1 + f(n-1,m-1) i.e we consider s[n]  in both subsequence
            --> if n!=m and s[n]!=s[m]  , return max(f(n-1,m) and f(n,m-1))
     */
    public int recursive(String str){
        return recursiveHelper(str,str.length(),str.length());
    }
    private int recursiveHelper(String str, int n, int m){
        if(n==0 || m==0)return 0;
        if(n==m || str.charAt(n-1)!=str.charAt(m-1))
            return Math.max(recursiveHelper(str,n-1,m), recursiveHelper(str,n,m-1));
        return 1 + recursiveHelper(str,n-1,m-1);
    }
    // time and space complexity O(n^2)
    public int memoization(String str){
        int n = str.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);
        return memoHelper(str,n,n,dp);
    }
    private int memoHelper(String str, int n, int m, int[][] dp){
        if(n==0 || m==0)return 0;
        if(dp[n][m]!=-1)return dp[n][m];
        if(n==m || str.charAt(n-1)!=str.charAt(m-1))
            return dp[n][m] = Math.max(memoHelper(str,n-1,m,dp), memoHelper(str,n,m-1,dp));
        return dp[n][m] =  1 + memoHelper(str,n-1,m-1,dp);
    }

    public int bottomUp(String str) {
        int n = str.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                if(i==j || str.charAt(i-1)!=str.charAt(j-1))
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                else dp[i][j] = 1+ dp[i-1][j-1];
        return dp[n][n];
    }
}
