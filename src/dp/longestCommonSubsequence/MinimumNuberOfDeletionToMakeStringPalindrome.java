package dp.longestCommonSubsequence;
// problem link : https://practice.geeksforgeeks.org/problems/minimum-deletitions/0#
    // time and space complexity O(n^2)
    // approach : find longest palindrome subsequence , and remove all other characters
public class MinimumNuberOfDeletionToMakeStringPalindrome {
    private static int findPalindrome(String str1,int n){
        StringBuilder sb = new StringBuilder(str1);
        sb.reverse();
        String str2 = sb.toString();
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        return n - dp[n][n];
    }
}
