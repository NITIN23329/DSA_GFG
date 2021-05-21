package dp.longestCommonSubsequence;
// problem link : https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1#
public class ShortestCommonSuperSequence {
    // time and space complexity O(nm)
    /*
        approach :
        1) find length of lowest common subsequence of s1 and s2 strings.
        2) to get our shortest common super sequence we will add those character of s2 to s1 which are not in lcs
     */
    public static int bottomUp(String s1, String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        // if n==0 || m==0 dp[n][m] = 0
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        int lcsLength = dp[n][m];
        return s1.length() + s2.length() - lcsLength;
    }
}
