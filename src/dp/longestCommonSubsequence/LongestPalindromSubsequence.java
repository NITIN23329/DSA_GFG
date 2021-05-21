package dp.longestCommonSubsequence;
// problem link : https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence/0#
public class LongestPalindromSubsequence {
    // time and space complexity O(n^2)
    /*
        approach :
               --> palindrome is a string which is same from left to right and right to left.
               --> if we start from left to right , s[left++]==s[right--]
                -->left say a = s[0 to n/2] , b = reverse(s[n/2 to n])
                --> a[i] == b[i] , same as finding lcs
               --> we find lcs of a string with its reverse
     */
    private static int longestPalindromeSubsequence(String s1,int n){
        String s2 = "";
        for(int i=0;i<s1.length();i++)
            s2 = s1.charAt(i)+s2;

        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        return dp[n][n];
    }
}
